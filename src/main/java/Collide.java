public final class Collide {
  public static double loss(VehicleGroup group, VehicleGroup other) {
    if (group.canCollide(other)) {
      return group.size() * other.size() * -1e-2;
    }

    return 0;
  }
}