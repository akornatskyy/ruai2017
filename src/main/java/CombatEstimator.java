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
    return 0;
  }

  private double enemy(VehicleGroup ally, VehicleGroup enemy, Vector target) {
    return 0;
  }
}