import model.VehicleType;

public final class Heal {
  public static double gain(VehicleGroup group, VehicleGroup other) {
    return calc(group, other) + calc(other, group);
  }

  private static double calc(VehicleGroup group, VehicleGroup other) {
    int healers = Math.min(
        group.getCountOfType(VehicleType.ARRV),
        other.getNumberOfWeakUnits());
    if (healers > other.size() * 0.2) {
      return healers;
    }

    return 0;
  }
}