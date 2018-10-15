import java.util.List;

public final class CombatEstimator implements Estimator {

  private final List<VehicleGroup> allies;
  private final List<VehicleGroup> enemies;
  private final Battlefield battlefield;

  public CombatEstimator(List<VehicleGroup> allies, List<VehicleGroup> enemies) {
    this.allies = allies;
    this.enemies = enemies;
    this.battlefield = new Battlefield(allies, enemies);
  }

  @Override
  public void update() {
    battlefield.update();
  }

  @Override
  public double calc(VehicleGroup group, Vector target) {
    double p = 0.0;
    for (VehicleGroup other : allies) {
      if (other.isAlive() && group != other) {
        p += ally(group, other, target);
      }
    }

    for (VehicleGroup other : enemies) {
      p += enemy(group, other, target);
    }

    final double WALL = 0.06;
    p -= Math.exp((-target.x + 18) / WALL) // left
         + Math.exp((-1006 + target.x) / WALL) // right
         + Math.exp((-target.y + 18) / WALL) // top
         + Math.exp((-1006 + target.y) / WALL); // bottom

    return p;
  }

  private double ally(VehicleGroup group, VehicleGroup other, Vector target) {
    double d = target.len(other.getCenter());
    double p = 0;
    double c = battlefield.collide(group, other);
    if (c != 0) {
      if (d <= 96) {
        double d2 = group.distance(target, other);
        if (d2 <= 16) {
          p = c * Math.pow(d2, -3);
        }
      }
    } else {
      double s = battlefield.shield(group, other);
      if (s != 0) {
        p = s * Math.exp(-d / 4);
      }
    }

    return p;
  }

  private double enemy(VehicleGroup ally, VehicleGroup enemy, Vector target) {
    double as = ally.getMinSpeed();
    double es = enemy.getMinSpeed();
    double a = battlefield.attack(ally, enemy);
    double s = a > 0 ? as / es : es / as;
    double d = target.len(enemy.getWeakCenter());
    return a * s * Math.exp(-d / 5);
  }
}