package model;

import java.util.Arrays;

/**
 * Class describing a vehicle. Also contains all properties of a circular unit.
 */
public class Vehicle extends CircularUnit {
    private final long playerId;
    private final int durability;
    private final int maxDurability;
    private final double maxSpeed;
    private final double visionRange;
    private final double squaredVisionRange;
    private final double groundAttackRange;
    private final double squaredGroundAttackRange;
    private final double aerialAttackRange;
    private final double squaredAerialAttackRange;
    private final int groundDamage;
    private final int aerialDamage;
    private final int groundDefence;
    private final int aerialDefence;
    private final int attackCooldownTicks;
    private final int remainingAttackCooldownTicks;
    private final VehicleType type;
    private final boolean aerial;
    private final boolean selected;
    private final int[] groups;

    public Vehicle(
            long id, double x, double y, double radius, long playerId, int durability, int maxDurability,
            double maxSpeed, double visionRange, double squaredVisionRange, double groundAttackRange,
            double squaredGroundAttackRange, double aerialAttackRange, double squaredAerialAttackRange,
            int groundDamage, int aerialDamage, int groundDefence, int aerialDefence, int attackCooldownTicks,
            int remainingAttackCooldownTicks, VehicleType type, boolean aerial, boolean selected, int[] groups) {
        super(id, x, y, radius);

        this.playerId = playerId;
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.maxSpeed = maxSpeed;
        this.visionRange = visionRange;
        this.squaredVisionRange = squaredVisionRange;
        this.groundAttackRange = groundAttackRange;
        this.squaredGroundAttackRange = squaredGroundAttackRange;
        this.aerialAttackRange = aerialAttackRange;
        this.squaredAerialAttackRange = squaredAerialAttackRange;
        this.groundDamage = groundDamage;
        this.aerialDamage = aerialDamage;
        this.groundDefence = groundDefence;
        this.aerialDefence = aerialDefence;
        this.attackCooldownTicks = attackCooldownTicks;
        this.remainingAttackCooldownTicks = remainingAttackCooldownTicks;
        this.type = type;
        this.aerial = aerial;
        this.selected = selected;
        this.groups = Arrays.copyOf(groups, groups.length);
    }

    public Vehicle(Vehicle vehicle, VehicleUpdate vehicleUpdate) {
        super(vehicle.getId(), vehicleUpdate.getX(), vehicleUpdate.getY(), vehicle.getRadius());

        this.playerId = vehicle.playerId;
        this.durability = vehicleUpdate.getDurability();
        this.maxDurability = vehicle.maxDurability;
        this.maxSpeed = vehicle.maxSpeed;
        this.visionRange = vehicle.visionRange;
        this.squaredVisionRange = vehicle.squaredVisionRange;
        this.groundAttackRange = vehicle.groundAttackRange;
        this.squaredGroundAttackRange = vehicle.squaredGroundAttackRange;
        this.aerialAttackRange = vehicle.aerialAttackRange;
        this.squaredAerialAttackRange = vehicle.squaredAerialAttackRange;
        this.groundDamage = vehicle.groundDamage;
        this.aerialDamage = vehicle.aerialDamage;
        this.groundDefence = vehicle.groundDefence;
        this.aerialDefence = vehicle.aerialDefence;
        this.attackCooldownTicks = vehicle.attackCooldownTicks;
        this.remainingAttackCooldownTicks = vehicleUpdate.getRemainingAttackCooldownTicks();
        this.type = vehicle.type;
        this.aerial = vehicle.aerial;
        this.selected = vehicleUpdate.isSelected();

        int[] updateGroups = vehicleUpdate.getGroups();
        this.groups = Arrays.copyOf(updateGroups, updateGroups.length);
    }

    /**
     * @return owner player's ID.
     */
    public long getPlayerId() {
        return playerId;
    }

    /**
     * @return current durability.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * @return maximal durability.
     */
    public int getMaxDurability() {
        return maxDurability;
    }

    /**
     * @return maximal distance that can be travelled in one tick
     * when not affected by terrain or weather. While rotating arc length is taken into account,
     * not the distance between start and finish positions.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @return maximal range (from center to center) at which this vehicle can detect other objects,
     * when not affected by terrain or weather.
     */
    public double getVisionRange() {
        return visionRange;
    }

    /**
     * @return squared maximal range (from center to center) at which this vehicle can detect other objects,
     * when not affected by terrain or weather.
     */
    public double getSquaredVisionRange() {
        return squaredVisionRange;
    }

    /**
     * @return maximal range (from center to center) at which this vehicle can attack ground units.
     */
    public double getGroundAttackRange() {
        return groundAttackRange;
    }

    /**
     * @return squared maximal range (from center to center) at which this vehicle can attack ground units.
     */
    public double getSquaredGroundAttackRange() {
        return squaredGroundAttackRange;
    }

    /**
     * @return maximal range (from center to center) at which this vehicle can attack aerial units.
     */
    public double getAerialAttackRange() {
        return aerialAttackRange;
    }

    /**
     * @return squared maximal range (from center to center) at which this vehicle can attack aerial units.
     */
    public double getSquaredAerialAttackRange() {
        return squaredAerialAttackRange;
    }

    /**
     * @return damage of one attack dealt to a ground unit.
     */
    public int getGroundDamage() {
        return groundDamage;
    }

    /**
     * @return damage of one attack dealt to an aerial unit.
     */
    public int getAerialDamage() {
        return aerialDamage;
    }

    /**
     * @return value of defence from ground units' attacks.
     */
    public int getGroundDefence() {
        return groundDefence;
    }

    /**
     * @return value of defence from aerial units' attacks.
     */
    public int getAerialDefence() {
        return aerialDefence;
    }

    /**
     * @return minimal possible interval between attacks.
     */
    public int getAttackCooldownTicks() {
        return attackCooldownTicks;
    }

    /**
     * @return amount of ticks before the vehicle can attack again.
     * In order to attack this value has to be equal zero.
     */
    public int getRemainingAttackCooldownTicks() {
        return remainingAttackCooldownTicks;
    }

    /**
     * @return vehicle's type.
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * @return {@code true} iff the vehicle is aerial.
     */
    public boolean isAerial() {
        return aerial;
    }

    /**
     * @return {@code true} iff the vehicle is selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @return list of groups that the vehicle belongs to.
     */
    public int[] getGroups() {
        return Arrays.copyOf(groups, groups.length);
    }
}
