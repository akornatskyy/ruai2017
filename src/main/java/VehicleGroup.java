import model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public final class VehicleGroup {

  private final int groupId;
  private final List<Vehicle> vehicles;
  private final Vector center = new Vector();

  private Vector target;
  private boolean changed = true;

  public VehicleGroup(int groupId, List<Vehicle> vehicles) {
    this.groupId = groupId;
    this.vehicles = vehicles;
  }

  public boolean update(Vehicle vehicle) {
    long id = vehicle.getId();
    for (int i = 0; i < vehicles.size(); i++) {
      if (vehicles.get(i).getId() == id) {
        vehicles.set(i, vehicle);
        changed = true;
        return true;
      }
    }

    return false;
  }

  public boolean remove(long vehicleId) {
    for (int i = 0; i < vehicles.size(); i++) {
      Vehicle vehicle = vehicles.get(i);
      if (vehicle.getId() == vehicleId) {
        vehicles.remove(i);
        changed = true;
        return true;
      }
    }

    return false;
  }

  public void update() {
    if (!changed) {
      return;
    }

    changed = false;

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

  public boolean isAlive() {
    return !vehicles.isEmpty();
  }

  public int getGroupId() {
    return groupId;
  }

  public Vector getCenter() {
    return center;
  }

  public Vector getTarget() {
    return target;
  }

  public void setTarget(Vector target) {
    this.target = target;
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