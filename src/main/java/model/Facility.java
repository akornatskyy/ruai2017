package model;

/**
 * This class describes a facility. A facility is a rectangular area on the map.
 */
public class Facility {
    private final long id;
    private final FacilityType type;
    private final long ownerPlayerId;
    private final double left;
    private final double top;
    private final double capturePoints;
    private final VehicleType vehicleType;
    private final int productionProgress;

    public Facility(
            long id, FacilityType type, long ownerPlayerId, double left, double top, double capturePoints,
            VehicleType vehicleType, int productionProgress) {
        this.id = id;
        this.type = type;
        this.ownerPlayerId = ownerPlayerId;
        this.left = left;
        this.top = top;
        this.capturePoints = capturePoints;
        this.vehicleType = vehicleType;
        this.productionProgress = productionProgress;
    }

    /**
     * @return the unique facility ID
     */
    public long getId() {
        return id;
    }

    /**
     * @return the facility type.
     */
    public FacilityType getType() {
        return type;
    }

    /**
     * @return the owner player ID or {@code -1}.
     */
    public long getOwnerPlayerId() {
        return ownerPlayerId;
    }

    /**
     * @return the leftmost X of the facility.
     */
    public double getLeft() {
        return left;
    }

    /**
     * @return the topmost Y of the facility.
     */
    public double getTop() {
        return top;
    }

    /**
     * @return the capture level of the facility in the range of {@code -game.maxFacilityCapturePoints} to
     * {@code game.maxFacilityCapturePoints}. The positive level means, that you are capturing this facility.
     * The negative level means, that some other player is capturing this facility.
     */
    public double getCapturePoints() {
        return capturePoints;
    }

    /**
     * @return the type of the vehicle that this factory produces or {@code null}. For control center the value is
     * always {@code null}.
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * @return the nonnegative number that is vehicle production progress. For control center the value is always
     * {@code 0}.
     */
    public int getProductionProgress() {
        return productionProgress;
    }
}
