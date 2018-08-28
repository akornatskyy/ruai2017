package model;

import java.util.Arrays;

/**
 * Class that partly describes a vehicle. Contains a unique vehicle's identifier as well as all vehicle's fields that
 * may be changed during the game.
 */
public class VehicleUpdate {
    private final long id;
    private final double x;
    private final double y;
    private final int durability;
    private final int remainingAttackCooldownTicks;
    private final boolean selected;
    private final int[] groups;

    public VehicleUpdate(
            long id, double x, double y, int durability, int remainingAttackCooldownTicks, boolean selected,
            int[] groups) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.durability = durability;
        this.remainingAttackCooldownTicks = remainingAttackCooldownTicks;
        this.selected = selected;
        this.groups = Arrays.copyOf(groups, groups.length);
    }

    /**
     * @return unique object's identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * @return the X of the unit's center. The X-axis is directed from left to right.
     */
    public double getX() {
        return x;
    }

    /**
     * @return the Y of the unit's center. The Y-axis is directed downward.
     */
    public double getY() {
        return y;
    }

    /**
     * @return current durability, or {@code 0} if the vehicle has either been destroyed or became invisible to you.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * @return amount of ticks before the vehicle can attack again.
     * In order to attack this value has to be equal zero.
     */
    public int getRemainingAttackCooldownTicks() {
        return remainingAttackCooldownTicks;
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
