package model;

/**
 * Facility type.
 */
public enum FacilityType {
    /**
     * Increases the limit of player actions for {@code game.additionalActionCountPerControlCenter} per
     * {@code game.actionDetectionInterval} game ticks. Also slightly reduced cooldown of tactical nuclear strikes.
     */
    CONTROL_CENTER,

    /**
     * The factory can produce vehicles of any type.
     */
    VEHICLE_FACTORY
}
