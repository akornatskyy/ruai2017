import model.Vehicle;
import model.VehicleType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Samples {
  public static VehicleGroup group(int groupId, List<Vehicle> army) {
    VehicleGroup group = new VehicleGroup(groupId, army);
    group.update();
    return group;
  }

  public static List<Vehicle> vehicles(int number, VehicleType type) {
    return IntStream.range(0, number)
        .mapToObj(i -> new Vehicle(
            i, 0, 0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, type, false, false, new int[] {}))
        .collect(Collectors.toList());
  }
}