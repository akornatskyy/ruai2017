import java.util.Arrays;
import java.util.List;

public final class FormationEstimator implements Estimator {

  private static final Vector[][] TARGETS = Arrays.stream(
      new double[][][] {
          {{0, 0}, {1, 0}, {0, 1}},
          {{1, 2}, {2, 1}, {0, 2}, {2, 0}, {2, 2}},
          {{1, 1}, {0, 1}, {1, 0}},
          {{1, 1}, {0, 1}, {1, 0}},
          {{0, 2}, {2, 0}, {1, 2}, {2, 1}, {1, 1}}
      })
      .map(route -> Arrays.stream(route)
          .map(c -> {
            Vector v = new Vector();
            v.set(c[0] * 75 + 45, c[1] * 75 + 45);
            return v;
          })
          .toArray(Vector[]::new))
      .toArray(Vector[][]::new);

  private final List<VehicleGroup> allies;

  public FormationEstimator(List<VehicleGroup> allies) {
    this.allies = allies;
  }

  @Override
  public double calc(VehicleGroup group, Vector target) {
    double p = attractive(group, target);
    for (VehicleGroup other : allies) {
      if (group != other) {
        p += repulsive(group, other, target);
      }
    }

    // does not move at exp^(-745) == 0
    final double WALL = 0.06;
    p -= Math.exp((-target.x + 18) / WALL) // left
         + Math.exp((-target.y + 18) / WALL); // top

    return p;
  }

  private static double attractive(VehicleGroup group, Vector target) {
    return Arrays.stream(TARGETS[group.getGroupId()])
        .mapToDouble(t -> Math.exp(-target.len(t)))
        .max()
        .orElse(0);
  }

  private static double repulsive(
      VehicleGroup group, VehicleGroup other, Vector target) {
    double p = 0;
    if (group.canCollide(other)) {
      double d = target.len(other.getCenter());
      if (d <= 96) {
        p = -Math.pow(d, -2);
      }
    }

    return p;
  }
}