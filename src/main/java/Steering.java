import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Steering {

  private static Logger LOGGER = Logger.get(Steering.class, true);

  private static final int NUMBER_OF_DIRECTIONS = 64;
  private static final List<Vector> DIRECTIONS = IntStream
      .range(0, NUMBER_OF_DIRECTIONS)
      .mapToObj(i -> {
        // in order from the center of the map clockwise
        double angle = 2.0 * i / NUMBER_OF_DIRECTIONS;
        angle = Math.PI * (angle - 1.75);

        Vector direction = new Vector();
        direction.set(Math.cos(angle), Math.sin(angle));
        return direction;
      })
      .collect(Collectors.toList());

  private static final int TICKS_PER_MOVE = 5;
  private static final double[] TICKS = IntStream
      .range(TICKS_PER_MOVE, TICKS_PER_MOVE * 20 + 1)
      .mapToDouble(t -> t * TICKS_PER_MOVE)
      .toArray();

  private final Estimator estimator;

  public Steering(Estimator estimator) {
    this.estimator = estimator;
  }

  public Vector seekTarget(VehicleGroup group) {
    Vector center = group.getCenter();
    double p = estimator.calc(group, center);
    double speed = group.getMinSpeed();
    return DIRECTIONS.stream()
        .map(direction -> {
          DirectionGradient r = null;
          Vector target;
          double last = Double.NEGATIVE_INFINITY;
          for (double tick : TICKS) {
            double distance = tick * speed;
            target = Vector.scl(direction, distance);
            target.add(center);
            if (target.x < 0 || target.y < 0 ||
                target.x > 1023 || target.y > 1023) {
              break;
            }

            double cp = estimator.calc(group, target);
            double delta = (cp - p) / tick;
            if (delta <= 0 || last > delta) {
              break;
            }

            last = delta;
            r = new DirectionGradient(target, direction, last, tick);
          }

          return r;
        })
        .filter(Objects::nonNull)
        .max(Comparator.comparingDouble(d -> d.delta))
        .map(dp -> {
          if (LOGGER.isEnabled()) {
            LOGGER.log("%s %s t: %.0f, p: %4.3e %4.3e",
                       group, dp.direction, dp.tick, p, dp.delta);
          }

          Vector target = group.getTarget();
          if (target != null && !center.equals(target)) {
            Vector opposite = new Vector();
            opposite.set(center);
            opposite.sub(target);
            opposite.norm();
            if (dp.direction.equals(opposite)) {
              if (LOGGER.isEnabled()) {
                LOGGER.log("WARN: omitting direction for %s", group);
              }

              return null;
            }
          }

          return dp.target;
        })
        .orElseGet(() -> {
          if (LOGGER.isEnabled()) {
            LOGGER.log("WARN: no feasible target for %s", group);
          }

          return null;
        });
  }

  private static final class DirectionGradient {
    final Vector target;
    final Vector direction;
    final double delta;
    final double tick;

    DirectionGradient(
        Vector target, Vector direction, double delta, double tick) {
      this.target = target;
      this.direction = direction;
      this.delta = delta;
      this.tick = tick;
    }
  }
}