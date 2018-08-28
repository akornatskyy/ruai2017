package model;

import java.util.Arrays;

/**
 * This class describes a game world. A world contains all players and game objects (``units’’).
 */
@SuppressWarnings("ForLoopWithMissingComponent")
public class World {
    private final int tickIndex;
    private final int tickCount;
    private final double width;
    private final double height;
    private final Player[] players;
    private final Vehicle[] newVehicles;
    private final VehicleUpdate[] vehicleUpdates;
    private final TerrainType[][] terrainByCellXY;
    private final WeatherType[][] weatherByCellXY;
    private final Facility[] facilities;

    public World(
            int tickIndex, int tickCount, double width, double height, Player[] players, Vehicle[] newVehicles,
            VehicleUpdate[] vehicleUpdates, TerrainType[][] terrainByCellXY, WeatherType[][] weatherByCellXY,
            Facility[] facilities) {
        this.tickIndex = tickIndex;
        this.tickCount = tickCount;
        this.width = width;
        this.height = height;
        this.players = Arrays.copyOf(players, players.length);
        this.newVehicles = Arrays.copyOf(newVehicles, newVehicles.length);
        this.vehicleUpdates = Arrays.copyOf(vehicleUpdates, vehicleUpdates.length);

        this.terrainByCellXY = new TerrainType[terrainByCellXY.length][];
        for (int x = terrainByCellXY.length; --x >= 0; ) {
            this.terrainByCellXY[x] = Arrays.copyOf(terrainByCellXY[x], terrainByCellXY[x].length);
        }

        this.weatherByCellXY = new WeatherType[weatherByCellXY.length][];
        for (int x = weatherByCellXY.length; --x >= 0; ) {
            this.weatherByCellXY[x] = Arrays.copyOf(weatherByCellXY[x], weatherByCellXY[x].length);
        }

        this.facilities = Arrays.copyOf(facilities, facilities.length);
    }

    /**
     * @return the current game tick.
     */
    public int getTickIndex() {
        return tickIndex;
    }

    /**
     * @return the base game duration in ticks. A real game duration may be lower. Equals to {@code game.tickCount}.
     */
    public int getTickCount() {
        return tickCount;
    }

    /**
     * @return the world width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the world height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return all players (in random order). After each tick the player objects are recreated.
     */
    public Player[] getPlayers() {
        return Arrays.copyOf(players, players.length);
    }

    /**
     * @return list of vehicles that had no information availavle in the precious tick.
     * It contains both newly created vehicles and those that already existed but were not visible before.
     */
    public Vehicle[] getNewVehicles() {
        return Arrays.copyOf(newVehicles, newVehicles.length);
    }

    /**
     * @return changing field values for each visible vehicle if at least one of these fields has been changed.
     * Durability value zero means that the vehicle is either destroyed or became invisible for you.
     */
    public VehicleUpdate[] getVehicleUpdates() {
        return Arrays.copyOf(vehicleUpdates, vehicleUpdates.length);
    }

    /**
     * @return terrain map.
     */
    public TerrainType[][] getTerrainByCellXY() {
        @SuppressWarnings("LocalVariableHidesMemberVariable") TerrainType[][] terrainByCellXY = this.terrainByCellXY;
        TerrainType[][] copiedTerrainByCellXY = new TerrainType[terrainByCellXY.length][];
        for (int x = terrainByCellXY.length; --x >= 0; ) {
            copiedTerrainByCellXY[x] = Arrays.copyOf(terrainByCellXY[x], terrainByCellXY[x].length);
        }
        return copiedTerrainByCellXY;
    }

    /**
     * @return weather map.
     */
    public WeatherType[][] getWeatherByCellXY() {
        @SuppressWarnings("LocalVariableHidesMemberVariable") WeatherType[][] weatherByCellXY = this.weatherByCellXY;
        WeatherType[][] copiedWeatherByCellXY = new WeatherType[weatherByCellXY.length][];
        for (int x = weatherByCellXY.length; --x >= 0; ) {
            copiedWeatherByCellXY[x] = Arrays.copyOf(weatherByCellXY[x], weatherByCellXY[x].length);
        }
        return copiedWeatherByCellXY;
    }

    /**
     * @return list of facilities (in random order).
     * Depending on implementation, corresponding objects may be or not recreated each tick.
     */
    public Facility[] getFacilities() {
        return Arrays.copyOf(facilities, facilities.length);
    }

    /**
     * @return your player.
     */
    public Player getMyPlayer() {
        int playerIndex = players.length;

        while (--playerIndex >= 0) {
            Player player = players[playerIndex];
            if (player.isMe()) {
                return player;
            }
        }

        return null;
    }

    /**
     * @return opponent's player.
     */
    public Player getOpponentPlayer() {
        int playerIndex = players.length;

        while (--playerIndex >= 0) {
            Player player = players[playerIndex];
            if (!player.isMe()) {
                return player;
            }
        }

        return null;
    }
}
