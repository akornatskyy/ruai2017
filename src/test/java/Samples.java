import model.Vehicle;
import model.VehicleType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

  public static List<Vehicle> vehicles(int... counts) {
    if (counts.length != 5) {
      throw new IllegalArgumentException();
    }

    return Stream.of(
        Samples.vehicles(counts[0], VehicleType.ARRV),
        Samples.vehicles(counts[1], VehicleType.FIGHTER),
        Samples.vehicles(counts[2], VehicleType.HELICOPTER),
        Samples.vehicles(counts[3], VehicleType.IFV),
        Samples.vehicles(counts[4], VehicleType.TANK))
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }
}