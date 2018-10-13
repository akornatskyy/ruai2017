import java.util.List;

public final class Battlefield {

  private final List<VehicleGroup> allies;
  private final List<VehicleGroup> enemies;

  private double[][] collides;
  private double[][] shields;
  private double[][] attacks;

  public Battlefield(List<VehicleGroup> allies, List<VehicleGroup> enemies) {
    this.allies = allies;
    this.enemies = enemies;
  }

  public void update() {
    int as = allies.size();
    collides = new double[as][as];
    shields = new double[as][as];
    int es = enemies.size();
    attacks = new double[as][es];
    for (int i = 0; i < as; i++) {
      VehicleGroup group = allies.get(i);
      for (int j = 0; j < as; j++) {
        VehicleGroup other = allies.get(j);
        double c = Collide.loss(group, other);
        if (c != 0) {
          collides[i][j] = c;
        } else {
          shields[i][j] = Shield.gain(group, other);
        }
      }

      for (int j = 0; j < es; j++) {
        attacks[i][j] = Attack.gain(group, enemies.get(j));
      }
    }
  }

  public double collide(VehicleGroup group, VehicleGroup other) {
    return collides[group.getGroupId()][other.getGroupId()];
  }

  public double shield(VehicleGroup group, VehicleGroup other) {
    return shields[group.getGroupId()][other.getGroupId()];
  }

  public double attack(VehicleGroup group, VehicleGroup other) {
    return attacks[group.getGroupId()][other.getGroupId()];
  }
}