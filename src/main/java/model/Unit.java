package model;

import static java.lang.StrictMath.hypot;

/**
 * Base class that describes any object (``unit'') in the game world.
 */
@SuppressWarnings({"AbstractClassWithoutAbstractMethods", "WeakerAccess"})
public abstract class Unit {
    private final long id;
    private final double x;
    private final double y;

    protected Unit(long id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the unique unit ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return the X of the unit's center. The X-axis is directed from left to right.
     */
    public final double getX() {
        return x;
    }

    /**
     * @return the Y of the unit's center. The Y-axis is directed downward.
     */
    public final double getY() {
        return y;
    }

    /**
     * @param x X-coordinate of the point to get the distance to.
     * @param y Y-coordinate of the point to get the distance to.
     * @return the range between the specified point and the center of this unit.
     */
    public double getDistanceTo(double x, double y) {
        return hypot(x - this.x, y - this.y);
    }

    /**
     * @param unit the unit to get the distance to.
     * @return the range between the center of the specified unit and the center of this unit.
     */
    public double getDistanceTo(Unit unit) {
        return getDistanceTo(unit.x, unit.y);
    }

    /**
     * @param x X-coordinate of the point to get the distance to.
     * @param y Y-coordinate of the point to get the distance to.
     * @return the squared range between the specified point and the center of this unit.
     */
    public double getSquaredDistanceTo(double x, double y) {
        double dx = x - this.x;
        double dy = y - this.y;
        return dx * dx + dy * dy;
    }

    /**
     * @param unit the unit to get the distance to.
     * @return the squared range between the center of the specified unit and the center of this unit.
     */
    public double getSquaredDistanceTo(Unit unit) {
        return getSquaredDistanceTo(unit.x, unit.y);
    }
}
