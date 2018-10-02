import model.Vehicle;
import model.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public final class VehicleGroup {

  private static final Logger LOGGER = Logger.get(VehicleGroup.class);

  private final int groupId;
  private final List<Vehicle> vehicles;
  private final int[] countOfType = new int[VehicleType.values().length];
  private final Vector center = new Vector();

  private Vector target;
  private boolean changed = true;
  private double minSpeed = 0;
  private int numberOfWeakUnits = 0;

  public VehicleGroup(int groupId, List<Vehicle> vehicles) {
    this.groupId = groupId;
    this.vehicles = vehicles;
    for (Vehicle vehicle : vehicles) {
      countOfType[vehicle.getType().ordinal()] += 1;
    }
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
        countOfType[vehicle.getType().ordinal()] -= 1;
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
    double speed = Double.MAX_VALUE;
    int wn = 0;
    for (Vehicle vehicle : vehicles) {
      if (vehicle.getDurability() < vehicle.getMaxDurability()) {
        wn++;
      }

      cx += vehicle.getX();
      cy += vehicle.getY();
      if (speed > vehicle.getMaxSpeed()) {
        speed = vehicle.getMaxSpeed();
      }
    }

    cx /= n;
    cy /= n;
    center.set(cx, cy);

    this.minSpeed = speed;
    this.numberOfWeakUnits = wn;
  }

  public boolean canCollide(VehicleGroup other) {
    boolean ta = this.isAerial();
    boolean oa = other.isAerial();
    return (ta & oa) || (!ta && !oa);
  }

  public boolean isAlive() {
    return !vehicles.isEmpty();
  }

  public int size() {
    return vehicles.size();
  }

  public int getCountOfType(VehicleType t) {
    return countOfType[t.ordinal()];
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
    if (LOGGER.isEnabled()) {
      LOGGER.log("%s %s -> %s", this, center, target);
    }

    this.target = target;
  }

  public double getMinSpeed() {
    return minSpeed;
  }

  public int getNumberOfWeakUnits() {
    return numberOfWeakUnits;
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

    // e.g. 0FH120 4T100
    return String.format("%d%s%d", groupId, types, vehicles.size());
  }

  private boolean isAerial() {
    return countOfType[VehicleType.FIGHTER.ordinal()] > 0 ||
           countOfType[VehicleType.HELICOPTER.ordinal()] > 0;
  }
}