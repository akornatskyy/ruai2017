package model;

/**
 * An encapsulated result of each move of your strategy.
 */
public class Move {
    private ActionType action;

    private int group;

    private double left;
    private double top;
    private double right;
    private double bottom;

    private double x;
    private double y;
    private double angle;
    private double factor;

    private double maxSpeed;
    private double maxAngularSpeed;

    private VehicleType vehicleType;

    private long facilityId = -1L;
    private long vehicleId = -1L;

    /**
     * @return the current action.
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * Sets the desired action.
     */
    public void setAction(ActionType action) {
        this.action = action;
    }

    /**
     * @return the current group of units.
     */
    public int getGroup() {
        return group;
    }

    /**
     * Sets the group of units for various actions.
     * <p>
     * This parameter is optional for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION} and
     * {@code ActionType.DESELECT}. If the group is set for these actions, then all other parameters
     * ({@code vehicleType}, {@code left}, {@code top}, {@code right}, {@code bottom}) will be ignored.
     * <p>
     * This parameter is required for {@code ActionType.ASSIGN}, {@code ActionType.DISMISS} and
     * {@code ActionType.DISBAND}. This is the only parameter for {@code ActionType.DISBAND}.
     * <p>
     * The correct values are integers in range of {@code 1} to {@code game.maxUnitGroup} both inclusive.
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * @return the current leftmost X of selection rectangle.
     */
    public double getLeft() {
        return left;
    }

    /**
     * Sets the leftmost X of selection rectangle.
     * <p>
     * This is required parameter for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION} and
     * {@code ActionType.DESELECT}, if the group is not set. Otherwise this value will be ignored.
     * <p>
     * The correct values are real numbers in range of {@code 0.0} to {@code right} both inclusive.
     */
    public void setLeft(double left) {
        this.left = left;
    }

    /**
     * @return the current topmost Y of selection rectangle.
     */
    public double getTop() {
        return top;
    }

    /**
     * Sets the topmost Y of selection rectangle.
     * <p>
     * This is required parameter for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION} and
     * {@code ActionType.DESELECT}, if the group is not set. Otherwise this value will be ignored.
     * <p>
     * The correct values are real numbers in range of {@code 0.0} to {@code bottom} both inclusive.
     */
    public void setTop(double top) {
        this.top = top;
    }

    /**
     * @return the current rightmost X of selection rectangle.
     */
    public double getRight() {
        return right;
    }

    /**
     * Sets the rightmost X of selection rectangle.
     * <p>
     * This is required parameter for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION} and
     * {@code ActionType.DESELECT}, if the group is not set. Otherwise this value will be ignored.
     * <p>
     * The correct values are real numbers in range of {@code left} to {@code game.worldWidth} both inclusive.
     */
    public void setRight(double right) {
        this.right = right;
    }

    /**
     * @return the current bottommost Y of selection rectangle.
     */
    public double getBottom() {
        return bottom;
    }

    /**
     * Sets the bottommost Y of selection rectangle.
     * <p>
     * This is required parameter for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION} and
     * {@code ActionType.DESELECT}, if the group is not set. Otherwise this value will be ignored.
     * <p>
     * The correct values are real numbers in range of {@code top} to {@code game.worldHeight} both inclusive.
     */
    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    /**
     * @return the current X of a point or vector.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the X of a point or vector.
     * <p>
     * This is required parameter for {@code ActionType.MOVE} and specifies the X offset.
     * <p>
     * This is required parameter for {@code ActionType.ROTATE} and specifies the X of the rotation center.
     * <p>
     * This is required parameter for {@code ActionType.SCALE} and specifies the X of the scale pivot.
     * <p>
     * This is required parameter for {@code ActionType.TACTICAL_NUCLEAR_STRIKE} and specifies the X of the explosion
     * center.
     * <p>
     * The correct values for {@code ActionType.MOVE} are real numbers in range of {@code -game.worldWidth} to
     * {@code game.worldWidth} both inclusive. The correct values for {@code ActionType.ROTATE} and
     * {@code ActionType.SCALE} are real numbers in range of {@code -game.worldWidth} to {@code 2.0 * game.worldWidth}
     * both inclusive. The correct values for {@code ActionType.TACTICAL_NUCLEAR_STRIKE} are real numbers in range of
     * {@code 0.0} to {@code game.worldWidth} both inclusive.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the current Y of a point or vector.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the Y of a point or vector.
     * <p>
     * This is required parameter for {@code ActionType.MOVE} and specifies the Y offset.
     * <p>
     * This is required parameter for {@code ActionType.ROTATE} and specifies the Y of the rotation center.
     * <p>
     * This is required parameter for {@code ActionType.SCALE} and specifies the Y of the scale pivot.
     * <p>
     * This is required parameter for {@code ActionType.TACTICAL_NUCLEAR_STRIKE} and specifies the Y of the explosion
     * center.
     * <p>
     * The correct values for {@code ActionType.MOVE} are real numbers in range of {@code -game.worldHeight} to
     * {@code game.worldHeight} both inclusive. The correct values for {@code ActionType.ROTATE} and
     * {@code ActionType.SCALE} are real numbers in range of {@code -game.worldHeight} to {@code 2.0 * game.worldHeight}
     * both inclusive. The correct values for {@code ActionType.TACTICAL_NUCLEAR_STRIKE} are real numbers in range of
     * {@code 0.0} to {@code game.worldHeight} both inclusive.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the current rotation angle.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the rotation angle.
     * <p>
     * This is required parameter for {@code ActionType.ROTATE}. The positive values mean clockwise rotation.
     * <p>
     * The correct values are real numbers in range of {@code -PI} to {@code PI} both inclusive.
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * @return the current scale factor.
     */
    public double getFactor() {
        return factor;
    }

    /**
     * Sets the scale factor.
     * <p>
     * This is required parameter for {@code ActionType.SCALE}. The values greater than {@code 1.0} increase formation
     * size, the values less than {@code 1.0} decrease formation size.
     * <p>
     * The correct values are real numbers in range of {@code 0.1} to {@code 10.0} both inclusive.
     */
    public void setFactor(double factor) {
        this.factor = factor;
    }

    /**
     * @return the current speed limit.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the speed limit.
     * <p>
     * This is optional parameter for {@code ActionType.MOVE}, {@code ActionType.ROTATE} and {@code ActionType.SCALE}.
     * If for {@code ActionType.ROTATE} the max angular speed is set, then this parameter will be ignored.
     * <p>
     * The correct values are real nonnegative numbers. The special {@code 0.0} value means that there is no limit.
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return the current angular speed limit.
     */
    public double getMaxAngularSpeed() {
        return maxAngularSpeed;
    }

    /**
     * Sets the angular speed limit.
     * <p>
     * This is optional parameter for {@code ActionType.ROTATE}. If this parameter is set, then {@code maxSpeed} will be
     * ignored.
     * <p>
     * The correct values are real numbers in range of {@code 0.0} to {@code PI} both inclusive. The special {@code 0.0}
     * value means that there is no limit.
     */
    public void setMaxAngularSpeed(double maxAngularSpeed) {
        this.maxAngularSpeed = maxAngularSpeed;
    }

    /**
     * @return the current vehicle type.
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the vehicle type.
     * <p>
     * This is optional filter parameter for {@code ActionType.CLEAR_AND_SELECT}, {@code ActionType.ADD_TO_SELECTION}
     * and {@code ActionType.DESELECT}. This parameter will be ignored, if the group is set.
     * <p>
     * This is optional filter parameter for {@code ActionType.SETUP_VEHICLE_PRODUCTION}. The production progress will
     * be zeroed in any case.
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @return the current facility ID.
     */
    public long getFacilityId() {
        return facilityId;
    }

    /**
     * Sets the facility ID.
     * <p>
     * This is required parameter for {@code ActionType.SETUP_VEHICLE_PRODUCTION}. If there is no factory with this ID
     * or it is not owned by your strategy, then the action will be ignored.
     */
    public void setFacilityId(long facilityId) {
        this.facilityId = facilityId;
    }

    /**
     * @return the current vehicle ID.
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets the vehicle ID.
     * <p>
     * This is required parameter for {@code ActionType.TACTICAL_NUCLEAR_STRIKE}. The action will be ignored, if there
     * is no vehicle with this ID, if unit with this ID is owned by other player or if the nuclear strike target is
     * beyond the vision range of the specified unit.
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
