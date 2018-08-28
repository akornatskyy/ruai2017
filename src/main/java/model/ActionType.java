package model;

/**
 * Available player actions.
 * <p>
 * A player can not perform any new action, if during last {@code game.actionDetectionInterval - 1} game ticks he
 * already performed maximum possible actions. At the start of the game this limit is {@code game.baseActionCount} for
 * each player. The limit increases for each captured control center.
 * <p>
 * The most actions require additional parameters to perform. The strategy can set up an action with parameters updating
 * fields of a {@code move} object. If the specified parameters are incorrect or not sufficient, the action will be
 * ignored by game simulator. However, each action that is specified and is not {@code NONE} counts in the list of last
 * actions.
 */
public enum ActionType {
    /**
     * Do nothing.
     */
    NONE,

    /**
     * Select units that match specified parameters.
     * Deselect units that do not match these parameters.
     * The units of other players are automatically excluded.
     */
    CLEAR_AND_SELECT,

    /**
     * Select units that match specified parameters.
     * Already selected units stay selected.
     * The units of other players are automatically excluded.
     */
    ADD_TO_SELECTION,

    /**
     * Deselect units that match specified parameters.
     */
    DESELECT,

    /**
     * Assign selected units to the specified group.
     */
    ASSIGN,

    /**
     * Dismiss selected units from the specified group.
     */
    DISMISS,

    /**
     * Disband the group.
     */
    DISBAND,

    /**
     * Order selected units to move in the specified direction direction.
     */
    MOVE,

    /**
     * Order selected units to rotate around the specified point.
     */
    ROTATE,

    /**
     * Scale the formation of selected units relative to the specified point.
     */
    SCALE,

    /**
     * Set up production of the specified vehicle type on factory.
     */
    SETUP_VEHICLE_PRODUCTION,

    /**
     * Request tactical nuclear strike.
     */
    TACTICAL_NUCLEAR_STRIKE
}
