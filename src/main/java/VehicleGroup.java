import model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public final class VehicleGroup {

  private final int groupId;
  private final List<Vehicle> vehicles;

  public VehicleGroup(int groupId, List<Vehicle> vehicles) {
    this.groupId = groupId;
    this.vehicles = vehicles;
  }

  public boolean update(Vehicle vehicle) {
    return true;
  }

  public boolean remove(long vehicleId) {
    return true;
  }

  public int getGroupId() {
    return groupId;
  }

  @Override
  public String toString() {
    if (vehicles.isEmpty()) {
      return groupId + "-";
    }

    String types = vehicles.stream()
        .map(v -> v.getType().toString())
        .distinct()
        .map(s -> s.substring(0, 1))
        .sorted()
        .collect(Collectors.joining());

    // e.g. G0FH120 G4T100
    return String.format("%d%s%d", groupId, types, vehicles.size());
  }
}