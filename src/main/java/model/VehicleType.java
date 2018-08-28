package model;

/**
 * Vehicle type.
 */
public enum VehicleType {
    /**
     * Armored repair and recovery vehicle. Ground unit.
     * Gradually restores durability of nearby vehicles.
     */
    ARRV,

    /**
     * Fighter. Aerial unit. Effective against other aerial units. Can not attack ground units.
     */
    FIGHTER,

    /**
     * Attack helicopter. Aerial unit. Can attack both aerial and ground units.
     */
    HELICOPTER,

    /**
     * Infantry fighting vehicle. Ground unit. Can attack both aerial and ground units.
     */
    IFV,

    /**
     * Tank. Ground unit. Effective against other ground units. Can also attack aerial units.
     */
    TANK
}
