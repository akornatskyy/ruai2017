package model;

/**
 * This base class describes any circular unit in the game world.
 */
@SuppressWarnings({"AbstractClassWithoutAbstractMethods", "AbstractClassNeverImplemented"})
public abstract class CircularUnit extends Unit {
    private final double radius;

    protected CircularUnit(long id, double x, double y, double radius) {
        super(id, x, y);

        this.radius = radius;
    }

    /**
     * @return the radius of this unit.
     */
    public double getRadius() {
        return radius;
    }
}
