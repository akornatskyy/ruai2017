import model.Vehicle;
import model.VehicleUpdate;

import java.util.HashMap;
import java.util.Map;

public class VehicleMap {

  private final Map<Long, Vehicle> vehicles = new HashMap<>(500);

  public void add(Vehicle vehicle) {
    vehicles.put(vehicle.getId(), vehicle);
  }

  public boolean update(VehicleUpdate u) {
    long id = u.getId();
    Vehicle vehicle = vehicles.get(id);
    if (vehicle == null) {
      return false;
    }

    if (u.getDurability() > 0) {
      vehicles.put(id, new Vehicle(vehicle, u));
    } else {
      vehicles.remove(id);
    }

    return true;
  }
}