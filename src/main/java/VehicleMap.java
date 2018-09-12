import model.Vehicle;
import model.VehicleUpdate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VehicleMap {

  private static Logger LOGGER = Logger.get(VehicleMap.class);

  private final Map<Long, Vehicle> vehicles = new HashMap<>(500);
  private final List<VehicleGroup> groups = new ArrayList<>();

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
      vehicle = new Vehicle(vehicle, u);
      vehicles.put(id, vehicle);
      for (int groupId : vehicle.getGroups()) {
        VehicleGroup group = groups.get(groupId - 1);
        if (!group.update(vehicle)) {
          LOGGER.log("WARN: unable to update vehicle for group %s", group);
        }
      }
    } else {
      vehicles.remove(id);
      for (int groupId : vehicle.getGroups()) {
        VehicleGroup group = groups.get(groupId - 1);
        if (!group.remove(id)) {
          LOGGER.log("WARN: unable to remove vehicle from group %s", group);
        }
      }
    }

    return true;
  }

  public Collection<Vehicle> getVehicles() {
    return vehicles.values();
  }

  public Collection<VehicleGroup> getGroups() {
    return groups;
  }
}