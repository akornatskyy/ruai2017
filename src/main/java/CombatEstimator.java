import java.util.List;

public final class CombatEstimator implements Estimator {

  private final List<VehicleGroup> allies;
  private final List<VehicleGroup> enemies;

  public CombatEstimator(List<VehicleGroup> allies, List<VehicleGroup> enemies) {
    this.allies = allies;
    this.enemies = enemies;
  }

  @Override
  public double calc(VehicleGroup group, Vector target) {
    return 0;
  }
}