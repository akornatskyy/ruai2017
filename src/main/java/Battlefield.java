import java.util.List;

public final class Battlefield {

  private final List<VehicleGroup> allies;
  private final List<VehicleGroup> enemies;

  public Battlefield(List<VehicleGroup> allies, List<VehicleGroup> enemies) {
    this.allies = allies;
    this.enemies = enemies;
  }

  public void update() {
  }

  public double collide(VehicleGroup group, VehicleGroup other) {
    return 0;
  }

  public double shield(VehicleGroup group, VehicleGroup other) {
    return 0;
  }

  public double heal(VehicleGroup group, VehicleGroup other) {
    return 0;
  }

  public double attack(VehicleGroup group, VehicleGroup other) {
    return 0;
  }
}