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
  private final Vector weakCenter = new Vector();

  private Vector target;
  private boolean changed = true;
  private double minSpeed = 0;
  private int numberOfWeakUnits = 0;
  private int health = 0;

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

    double cx = 0, cy = 0, wx = 0, wy = 0;
    int n = vehicles.size();
    double speed = Double.MAX_VALUE;
    int wn = 0;
    int durability = 0;
    for (Vehicle vehicle : vehicles) {
      durability += vehicle.getDurability();
      if (vehicle.getDurability() < vehicle.getMaxDurability()) {
        wx += vehicle.getX();
        wy += vehicle.getY();
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

    if (wn == 0) {
      weakCenter.set(cx, cy);
    } else {
      weakCenter.set(wx / wn, wy / wn);
    }

    this.minSpeed = speed;
    this.numberOfWeakUnits = wn;
    this.health = durability;
  }

  public boolean canCollide(VehicleGroup other) {
    boolean ta = this.isAerial();
    boolean oa = other.isAerial();
    return (ta & oa) || (!ta && !oa);
  }

  public double density() {
    final double UNIT_RADIUS = 2;
    final double UNIT_DENSITY = 1 / (4 * UNIT_RADIUS * UNIT_RADIUS);
    int n = vehicles.size();
    if (n <= 1) {
      return n * UNIT_DENSITY;
    }

    Vehicle vehicle = vehicles.get(0);
    double left = vehicle.getX(), top = vehicle.getY();
    double right = left, bottom = top;
    for (int i = 1; i < n; i++) {
      vehicle = vehicles.get(i);
      double x = vehicle.getX(), y = vehicle.getY();
      if (x < left) {
        left = x;
      } else if (x > right) {
        right = x;
      }

      if (y < top) {
        top = y;
      } else if (y > bottom) {
        bottom = y;
      }
    }

    double area = (right - left) * (bottom - top);
    double d = n / area;

    // LOGGER.log("%s density: %s, area: %s", this, d, area);

    return d;
  }

  public double distance(Vector next, VehicleGroup other) {
    Vector delta = new Vector();
    Vector ot = other.getTarget();
    if (ot != null) {
      Vector oc = other.getCenter();
      double otherTicks = oc.len(ot) / other.minSpeed;
      double ticks = next.len(center) / minSpeed;
      if (otherTicks > ticks) {
        otherTicks = ticks;
      }

      delta.set(ot);
      delta.sub(oc);
      delta.norm();
      delta.scl(otherTicks);
    }

    List<Vector> otherShifted = other.vehicles.stream()
        .map(v -> {
          Vector p = new Vector();
          p.set(v.getX(), v.getY());
          p.add(delta);
          return p;
        })
        .collect(Collectors.toList());

    delta.set(next);
    delta.sub(center);
    double md = Double.MAX_VALUE;
    for (Vehicle v : vehicles) {
      Vector p = new Vector();
      p.set(v.getX(), v.getY());
      p.add(delta);
      for (Vector v2 : otherShifted) {
        double d = p.len2(v2.x, v2.y);
        if (d < md) {
          md = d;
        }
      }
    }

    return Math.sqrt(md);
  }

  public Vector getWeakCenter() {
    return weakCenter;
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

  public int getHealth() {
    return health;
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

  private boolean isAerial() {
    return countOfType[VehicleType.FIGHTER.ordinal()] > 0 ||
           countOfType[VehicleType.HELICOPTER.ordinal()] > 0;
  }
}