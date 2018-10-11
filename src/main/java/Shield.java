import model.VehicleType;

import java.util.List;

public final class Shield {
  public static double gain(VehicleGroup group, VehicleGroup other) {
    int t = other.getCountOfType(VehicleType.TANK);
    return (group.getCountOfType(VehicleType.FIGHTER) * t +
            group.getCountOfType(VehicleType.HELICOPTER)
            * (other.getCountOfType(VehicleType.IFV) + t))
           * 1e-13;
  }
}