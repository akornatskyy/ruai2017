import model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public final class VehicleGroup {

  private final int groupId;
  private final List<Vehicle> vehicles;
  private final Vector center = new Vector();

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

  public void update() {
    double cx = 0, cy = 0;
    int n = vehicles.size();
    for (Vehicle vehicle : vehicles) {
      cx += vehicle.getX();
      cy += vehicle.getY();
    }

    cx /= n;
    cy /= n;
    center.set(cx, cy);
  }

  public int getGroupId() {
    return groupId;
  }

  public Vector getCenter() {
    return center;
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