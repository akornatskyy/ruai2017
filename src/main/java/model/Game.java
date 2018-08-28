package model;

/**
 * An instance of this class contains all game constants.
 */
public class Game {
    private final long randomSeed;
    private final int tickCount;
    private final double worldWidth;
    private final double worldHeight;
    private final boolean fogOfWarEnabled;
    private final int victoryScore;
    private final int facilityCaptureScore;
    private final int vehicleEliminationScore;
    private final int actionDetectionInterval;
    private final int baseActionCount;
    private final int additionalActionCountPerControlCenter;
    private final int maxUnitGroup;
    private final int terrainWeatherMapColumnCount;
    private final int terrainWeatherMapRowCount;
    private final double plainTerrainVisionFactor;
    private final double plainTerrainStealthFactor;
    private final double plainTerrainSpeedFactor;
    private final double swampTerrainVisionFactor;
    private final double swampTerrainStealthFactor;
    private final double swampTerrainSpeedFactor;
    private final double forestTerrainVisionFactor;
    private final double forestTerrainStealthFactor;
    private final double forestTerrainSpeedFactor;
    private final double clearWeatherVisionFactor;
    private final double clearWeatherStealthFactor;
    private final double clearWeatherSpeedFactor;
    private final double cloudWeatherVisionFactor;
    private final double cloudWeatherStealthFactor;
    private final double cloudWeatherSpeedFactor;
    private final double rainWeatherVisionFactor;
    private final double rainWeatherStealthFactor;
    private final double rainWeatherSpeedFactor;
    private final double vehicleRadius;
    private final int tankDurability;
    private final double tankSpeed;
    private final double tankVisionRange;
    private final double tankGroundAttackRange;
    private final double tankAerialAttackRange;
    private final int tankGroundDamage;
    private final int tankAerialDamage;
    private final int tankGroundDefence;
    private final int tankAerialDefence;
    private final int tankAttackCooldownTicks;
    private final int tankProductionCost;
    private final int ifvDurability;
    private final double ifvSpeed;
    private final double ifvVisionRange;
    private final double ifvGroundAttackRange;
    private final double ifvAerialAttackRange;
    private final int ifvGroundDamage;
    private final int ifvAerialDamage;
    private final int ifvGroundDefence;
    private final int ifvAerialDefence;
    private final int ifvAttackCooldownTicks;
    private final int ifvProductionCost;
    private final int arrvDurability;
    private final double arrvSpeed;
    private final double arrvVisionRange;
    private final int arrvGroundDefence;
    private final int arrvAerialDefence;
    private final int arrvProductionCost;
    private final double arrvRepairRange;
    private final double arrvRepairSpeed;
    private final int helicopterDurability;
    private final double helicopterSpeed;
    private final double helicopterVisionRange;
    private final double helicopterGroundAttackRange;
    private final double helicopterAerialAttackRange;
    private final int helicopterGroundDamage;
    private final int helicopterAerialDamage;
    private final int helicopterGroundDefence;
    private final int helicopterAerialDefence;
    private final int helicopterAttackCooldownTicks;
    private final int helicopterProductionCost;
    private final int fighterDurability;
    private final double fighterSpeed;
    private final double fighterVisionRange;
    private final double fighterGroundAttackRange;
    private final double fighterAerialAttackRange;
    private final int fighterGroundDamage;
    private final int fighterAerialDamage;
    private final int fighterGroundDefence;
    private final int fighterAerialDefence;
    private final int fighterAttackCooldownTicks;
    private final int fighterProductionCost;
    private final double maxFacilityCapturePoints;
    private final double facilityCapturePointsPerVehiclePerTick;
    private final double facilityWidth;
    private final double facilityHeight;
    private final int baseTacticalNuclearStrikeCooldown;
    private final int tacticalNuclearStrikeCooldownDecreasePerControlCenter;
    private final double maxTacticalNuclearStrikeDamage;
    private final double tacticalNuclearStrikeRadius;
    private final int tacticalNuclearStrikeDelay;

    @SuppressWarnings("OverlyLongMethod")
    public Game(
            long randomSeed, int tickCount, double worldWidth, double worldHeight, boolean fogOfWarEnabled,
            int victoryScore, int facilityCaptureScore, int vehicleEliminationScore, int actionDetectionInterval,
            int baseActionCount, int additionalActionCountPerControlCenter, int maxUnitGroup,
            int terrainWeatherMapColumnCount, int terrainWeatherMapRowCount, double plainTerrainVisionFactor,
            double plainTerrainStealthFactor, double plainTerrainSpeedFactor, double swampTerrainVisionFactor,
            double swampTerrainStealthFactor, double swampTerrainSpeedFactor, double forestTerrainVisionFactor,
            double forestTerrainStealthFactor, double forestTerrainSpeedFactor, double clearWeatherVisionFactor,
            double clearWeatherStealthFactor, double clearWeatherSpeedFactor, double cloudWeatherVisionFactor,
            double cloudWeatherStealthFactor, double cloudWeatherSpeedFactor, double rainWeatherVisionFactor,
            double rainWeatherStealthFactor, double rainWeatherSpeedFactor, double vehicleRadius, int tankDurability,
            double tankSpeed, double tankVisionRange, double tankGroundAttackRange, double tankAerialAttackRange,
            int tankGroundDamage, int tankAerialDamage, int tankGroundDefence, int tankAerialDefence,
            int tankAttackCooldownTicks, int tankProductionCost, int ifvDurability, double ifvSpeed,
            double ifvVisionRange, double ifvGroundAttackRange, double ifvAerialAttackRange, int ifvGroundDamage,
            int ifvAerialDamage, int ifvGroundDefence, int ifvAerialDefence, int ifvAttackCooldownTicks,
            int ifvProductionCost, int arrvDurability, double arrvSpeed, double arrvVisionRange, int arrvGroundDefence,
            int arrvAerialDefence, int arrvProductionCost, double arrvRepairRange, double arrvRepairSpeed,
            int helicopterDurability, double helicopterSpeed, double helicopterVisionRange,
            double helicopterGroundAttackRange, double helicopterAerialAttackRange, int helicopterGroundDamage,
            int helicopterAerialDamage, int helicopterGroundDefence, int helicopterAerialDefence,
            int helicopterAttackCooldownTicks, int helicopterProductionCost, int fighterDurability, double fighterSpeed,
            double fighterVisionRange, double fighterGroundAttackRange, double fighterAerialAttackRange,
            int fighterGroundDamage, int fighterAerialDamage, int fighterGroundDefence, int fighterAerialDefence,
            int fighterAttackCooldownTicks, int fighterProductionCost, double maxFacilityCapturePoints,
            double facilityCapturePointsPerVehiclePerTick, double facilityWidth, double facilityHeight,
            int baseTacticalNuclearStrikeCooldown, int tacticalNuclearStrikeCooldownDecreasePerControlCenter,
            double maxTacticalNuclearStrikeDamage, double tacticalNuclearStrikeRadius, int tacticalNuclearStrikeDelay) {
        this.randomSeed = randomSeed;
        this.tickCount = tickCount;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.fogOfWarEnabled = fogOfWarEnabled;
        this.victoryScore = victoryScore;
        this.facilityCaptureScore = facilityCaptureScore;
        this.vehicleEliminationScore = vehicleEliminationScore;
        this.actionDetectionInterval = actionDetectionInterval;
        this.baseActionCount = baseActionCount;
        this.additionalActionCountPerControlCenter = additionalActionCountPerControlCenter;
        this.maxUnitGroup = maxUnitGroup;
        this.terrainWeatherMapColumnCount = terrainWeatherMapColumnCount;
        this.terrainWeatherMapRowCount = terrainWeatherMapRowCount;
        this.plainTerrainVisionFactor = plainTerrainVisionFactor;
        this.plainTerrainStealthFactor = plainTerrainStealthFactor;
        this.plainTerrainSpeedFactor = plainTerrainSpeedFactor;
        this.swampTerrainVisionFactor = swampTerrainVisionFactor;
        this.swampTerrainStealthFactor = swampTerrainStealthFactor;
        this.swampTerrainSpeedFactor = swampTerrainSpeedFactor;
        this.forestTerrainVisionFactor = forestTerrainVisionFactor;
        this.forestTerrainStealthFactor = forestTerrainStealthFactor;
        this.forestTerrainSpeedFactor = forestTerrainSpeedFactor;
        this.clearWeatherVisionFactor = clearWeatherVisionFactor;
        this.clearWeatherStealthFactor = clearWeatherStealthFactor;
        this.clearWeatherSpeedFactor = clearWeatherSpeedFactor;
        this.cloudWeatherVisionFactor = cloudWeatherVisionFactor;
        this.cloudWeatherStealthFactor = cloudWeatherStealthFactor;
        this.cloudWeatherSpeedFactor = cloudWeatherSpeedFactor;
        this.rainWeatherVisionFactor = rainWeatherVisionFactor;
        this.rainWeatherStealthFactor = rainWeatherStealthFactor;
        this.rainWeatherSpeedFactor = rainWeatherSpeedFactor;
        this.vehicleRadius = vehicleRadius;
        this.tankDurability = tankDurability;
        this.tankSpeed = tankSpeed;
        this.tankVisionRange = tankVisionRange;
        this.tankGroundAttackRange = tankGroundAttackRange;
        this.tankAerialAttackRange = tankAerialAttackRange;
        this.tankGroundDamage = tankGroundDamage;
        this.tankAerialDamage = tankAerialDamage;
        this.tankGroundDefence = tankGroundDefence;
        this.tankAerialDefence = tankAerialDefence;
        this.tankAttackCooldownTicks = tankAttackCooldownTicks;
        this.tankProductionCost = tankProductionCost;
        this.ifvDurability = ifvDurability;
        this.ifvSpeed = ifvSpeed;
        this.ifvVisionRange = ifvVisionRange;
        this.ifvGroundAttackRange = ifvGroundAttackRange;
        this.ifvAerialAttackRange = ifvAerialAttackRange;
        this.ifvGroundDamage = ifvGroundDamage;
        this.ifvAerialDamage = ifvAerialDamage;
        this.ifvGroundDefence = ifvGroundDefence;
        this.ifvAerialDefence = ifvAerialDefence;
        this.ifvAttackCooldownTicks = ifvAttackCooldownTicks;
        this.ifvProductionCost = ifvProductionCost;
        this.arrvDurability = arrvDurability;
        this.arrvSpeed = arrvSpeed;
        this.arrvVisionRange = arrvVisionRange;
        this.arrvGroundDefence = arrvGroundDefence;
        this.arrvAerialDefence = arrvAerialDefence;
        this.arrvProductionCost = arrvProductionCost;
        this.arrvRepairRange = arrvRepairRange;
        this.arrvRepairSpeed = arrvRepairSpeed;
        this.helicopterDurability = helicopterDurability;
        this.helicopterSpeed = helicopterSpeed;
        this.helicopterVisionRange = helicopterVisionRange;
        this.helicopterGroundAttackRange = helicopterGroundAttackRange;
        this.helicopterAerialAttackRange = helicopterAerialAttackRange;
        this.helicopterGroundDamage = helicopterGroundDamage;
        this.helicopterAerialDamage = helicopterAerialDamage;
        this.helicopterGroundDefence = helicopterGroundDefence;
        this.helicopterAerialDefence = helicopterAerialDefence;
        this.helicopterAttackCooldownTicks = helicopterAttackCooldownTicks;
        this.helicopterProductionCost = helicopterProductionCost;
        this.fighterDurability = fighterDurability;
        this.fighterSpeed = fighterSpeed;
        this.fighterVisionRange = fighterVisionRange;
        this.fighterGroundAttackRange = fighterGroundAttackRange;
        this.fighterAerialAttackRange = fighterAerialAttackRange;
        this.fighterGroundDamage = fighterGroundDamage;
        this.fighterAerialDamage = fighterAerialDamage;
        this.fighterGroundDefence = fighterGroundDefence;
        this.fighterAerialDefence = fighterAerialDefence;
        this.fighterAttackCooldownTicks = fighterAttackCooldownTicks;
        this.fighterProductionCost = fighterProductionCost;
        this.maxFacilityCapturePoints = maxFacilityCapturePoints;
        this.facilityCapturePointsPerVehiclePerTick = facilityCapturePointsPerVehiclePerTick;
        this.facilityWidth = facilityWidth;
        this.facilityHeight = facilityHeight;
        this.baseTacticalNuclearStrikeCooldown = baseTacticalNuclearStrikeCooldown;
        this.tacticalNuclearStrikeCooldownDecreasePerControlCenter = tacticalNuclearStrikeCooldownDecreasePerControlCenter;
        this.maxTacticalNuclearStrikeDamage = maxTacticalNuclearStrikeDamage;
        this.tacticalNuclearStrikeRadius = tacticalNuclearStrikeRadius;
        this.tacticalNuclearStrikeDelay = tacticalNuclearStrikeDelay;
    }

    /**
     * @return the number that is highly recommended to use as a seed for RNG (generator of pseudo-random numbers).
     */
    public long getRandomSeed() {
        return randomSeed;
    }

    /**
     * @return the base game duration in ticks. A real game duration may be lower. Equals to {@code world.tickCount}.
     */
    public int getTickCount() {
        return tickCount;
    }

    /**
     * @return the width of the map.
     */
    public double getWorldWidth() {
        return worldWidth;
    }

    /**
     * @return the height of the map.
     */
    public double getWorldHeight() {
        return worldHeight;
    }

    /**
     * @return {@code true} if and only if the fog of war is enabled in the current game.
     */
    public boolean isFogOfWarEnabled() {
        return fogOfWarEnabled;
    }

    /**
     * @return the amount of score points received for destroying all enemy units.
     */
    public int getVictoryScore() {
        return victoryScore;
    }

    /**
     * @return the amount of score points for capturing a facility.
     */
    public int getFacilityCaptureScore() {
        return facilityCaptureScore;
    }

    /**
     * @return the amount of score points for destroying a single enemy unit.
     */
    public int getVehicleEliminationScore() {
        return vehicleEliminationScore;
    }

    /**
     * @return the interval that is used to limit player actions.
     */
    public int getActionDetectionInterval() {
        return actionDetectionInterval;
    }

    /**
     * @return the base action count that player can perform in {@code actionDetectionInterval} ticks.
     */
    public int getBaseActionCount() {
        return baseActionCount;
    }

    /**
     * @return the additional action count per each captured control center.
     */
    public int getAdditionalActionCountPerControlCenter() {
        return additionalActionCountPerControlCenter;
    }

    /**
     * @return the max index of a unit group.
     */
    public int getMaxUnitGroup() {
        return maxUnitGroup;
    }

    /**
     * @return the count of columns in terrain/weather maps.
     */
    public int getTerrainWeatherMapColumnCount() {
        return terrainWeatherMapColumnCount;
    }

    /**
     * @return the count of rows in terrain/weather maps.
     */
    public int getTerrainWeatherMapRowCount() {
        return terrainWeatherMapRowCount;
    }

    /**
     * @return the vision range factor of a ground vehicle in plain terrain.
     */
    public double getPlainTerrainVisionFactor() {
        return plainTerrainVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect a ground vehicle in plain terrain.
     */
    public double getPlainTerrainStealthFactor() {
        return plainTerrainStealthFactor;
    }

    /**
     * @return the speed factor of ground vehicles in plain terrain.
     */
    public double getPlainTerrainSpeedFactor() {
        return plainTerrainSpeedFactor;
    }

    /**
     * @return the vision range factor of a ground vehicle in swamp terrain.
     */
    public double getSwampTerrainVisionFactor() {
        return swampTerrainVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect a ground vehicle in swamp terrain.
     */
    public double getSwampTerrainStealthFactor() {
        return swampTerrainStealthFactor;
    }

    /**
     * @return the speed factor of ground vehicles in swamp terrain.
     */
    public double getSwampTerrainSpeedFactor() {
        return swampTerrainSpeedFactor;
    }

    /**
     * @return the vision range factor of a ground vehicle in forest terrain.
     */
    public double getForestTerrainVisionFactor() {
        return forestTerrainVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect a ground vehicle in forest terrain.
     */
    public double getForestTerrainStealthFactor() {
        return forestTerrainStealthFactor;
    }

    /**
     * @return the speed factor of ground vehicles in forest terrain.
     */
    public double getForestTerrainSpeedFactor() {
        return forestTerrainSpeedFactor;
    }

    /**
     * @return the vision range factor of an aerial vehicle in clear weather.
     */
    public double getClearWeatherVisionFactor() {
        return clearWeatherVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect an aerial vehicle in clear weather.
     */
    public double getClearWeatherStealthFactor() {
        return clearWeatherStealthFactor;
    }

    /**
     * @return the speed factor of aerial vehicles in clear weather.
     */
    public double getClearWeatherSpeedFactor() {
        return clearWeatherSpeedFactor;
    }

    /**
     * @return the vision range factor of an aerial vehicle in cloud weather.
     */
    public double getCloudWeatherVisionFactor() {
        return cloudWeatherVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect an aerial vehicle in cloud weather.
     */
    public double getCloudWeatherStealthFactor() {
        return cloudWeatherStealthFactor;
    }

    /**
     * @return the speed factor of aerial vehicles in cloud weather.
     */
    public double getCloudWeatherSpeedFactor() {
        return cloudWeatherSpeedFactor;
    }

    /**
     * @return the vision range factor of an aerial vehicle in rain weather.
     */
    public double getRainWeatherVisionFactor() {
        return rainWeatherVisionFactor;
    }

    /**
     * @return the vision range factor of any vehicle that is trying to detect an aerial vehicle in rain weather.
     */
    public double getRainWeatherStealthFactor() {
        return rainWeatherStealthFactor;
    }

    /**
     * @return the speed factor of aerial vehicles in rain weather.
     */
    public double getRainWeatherSpeedFactor() {
        return rainWeatherSpeedFactor;
    }

    /**
     * @return the radius of a vehicle.
     */
    public double getVehicleRadius() {
        return vehicleRadius;
    }

    /**
     * @return the maximal durability of a tank.
     */
    public int getTankDurability() {
        return tankDurability;
    }

    /**
     * @return the maximal speed of a tank.
     */
    public double getTankSpeed() {
        return tankSpeed;
    }

    /**
     * @return the base vision range of a tank.
     */
    public double getTankVisionRange() {
        return tankVisionRange;
    }

    /**
     * @return the attack range of a tank against ground targets.
     */
    public double getTankGroundAttackRange() {
        return tankGroundAttackRange;
    }

    /**
     * @return the attack range of a tank against aerial targets.
     */
    public double getTankAerialAttackRange() {
        return tankAerialAttackRange;
    }

    /**
     * @return the attack damage of a tank against ground targets.
     */
    public int getTankGroundDamage() {
        return tankGroundDamage;
    }

    /**
     * @return the attack damage of a tank against aerial targets.
     */
    public int getTankAerialDamage() {
        return tankAerialDamage;
    }

    /**
     * @return the defence of a tank against ground attacks.
     */
    public int getTankGroundDefence() {
        return tankGroundDefence;
    }

    /**
     * @return the defence of a tank against aerial attacks.
     */
    public int getTankAerialDefence() {
        return tankAerialDefence;
    }

    /**
     * @return the attack cooldown of a tank.
     */
    public int getTankAttackCooldownTicks() {
        return tankAttackCooldownTicks;
    }

    /**
     * @return the amount of ticks to produce a tank on a factory.
     */
    public int getTankProductionCost() {
        return tankProductionCost;
    }

    /**
     * @return the maximal durability of an IFV.
     */
    public int getIfvDurability() {
        return ifvDurability;
    }

    /**
     * @return the maximal speed of an IFV.
     */
    public double getIfvSpeed() {
        return ifvSpeed;
    }

    /**
     * @return the base vision range of an IFV.
     */
    public double getIfvVisionRange() {
        return ifvVisionRange;
    }

    /**
     * @return the attack range of an IFV against ground targets.
     */
    public double getIfvGroundAttackRange() {
        return ifvGroundAttackRange;
    }

    /**
     * @return the attack range of an IFV against aerial targets.
     */
    public double getIfvAerialAttackRange() {
        return ifvAerialAttackRange;
    }

    /**
     * @return the attack damage of an IFV against ground targets.
     */
    public int getIfvGroundDamage() {
        return ifvGroundDamage;
    }

    /**
     * @return the attack damage of an IFV against aerial targets.
     */
    public int getIfvAerialDamage() {
        return ifvAerialDamage;
    }

    /**
     * @return the defence of an IFV against ground attacks.
     */
    public int getIfvGroundDefence() {
        return ifvGroundDefence;
    }

    /**
     * @return the defence of an IFV against aerial attacks.
     */
    public int getIfvAerialDefence() {
        return ifvAerialDefence;
    }

    /**
     * @return the attack cooldown of an IFV.
     */
    public int getIfvAttackCooldownTicks() {
        return ifvAttackCooldownTicks;
    }

    /**
     * @return the amount of ticks to produce an IFV on a factory.
     */
    public int getIfvProductionCost() {
        return ifvProductionCost;
    }

    /**
     * @return the maximal durability of an ARRV.
     */
    public int getArrvDurability() {
        return arrvDurability;
    }

    /**
     * @return the maximal speed of an ARRV.
     */
    public double getArrvSpeed() {
        return arrvSpeed;
    }

    /**
     * @return the base vision range of an ARRV.
     */
    public double getArrvVisionRange() {
        return arrvVisionRange;
    }

    /**
     * @return the defence of an ARRV against ground attacks.
     */
    public int getArrvGroundDefence() {
        return arrvGroundDefence;
    }

    /**
     * @return the defence of an ARRV against aerial attacks.
     */
    public int getArrvAerialDefence() {
        return arrvAerialDefence;
    }

    /**
     * @return the amount of ticks to produce an ARRV on a factory.
     */
    public int getArrvProductionCost() {
        return arrvProductionCost;
    }

    /**
     * @return the repair range of an ARRV.
     */
    public double getArrvRepairRange() {
        return arrvRepairRange;
    }

    /**
     * @return the repair amount of an ARRV per tick.
     */
    public double getArrvRepairSpeed() {
        return arrvRepairSpeed;
    }

    /**
     * @return the maximal durability of a helicopter.
     */
    public int getHelicopterDurability() {
        return helicopterDurability;
    }

    /**
     * @return the maximal speed of a helicopter.
     */
    public double getHelicopterSpeed() {
        return helicopterSpeed;
    }

    /**
     * @return the base vision range of a helicopter.
     */
    public double getHelicopterVisionRange() {
        return helicopterVisionRange;
    }

    /**
     * @return the attack range of a helicopter against ground targets.
     */
    public double getHelicopterGroundAttackRange() {
        return helicopterGroundAttackRange;
    }

    /**
     * @return the attack range of a helicopter against aerial targets.
     */
    public double getHelicopterAerialAttackRange() {
        return helicopterAerialAttackRange;
    }

    /**
     * @return the attack damage of a helicopter against ground targets.
     */
    public int getHelicopterGroundDamage() {
        return helicopterGroundDamage;
    }

    /**
     * @return the attack damage of a helicopter against aerial targets.
     */
    public int getHelicopterAerialDamage() {
        return helicopterAerialDamage;
    }

    /**
     * @return the defence of a helicopter against ground attacks.
     */
    public int getHelicopterGroundDefence() {
        return helicopterGroundDefence;
    }

    /**
     * @return the defence of a helicopter against aerial attacks.
     */
    public int getHelicopterAerialDefence() {
        return helicopterAerialDefence;
    }

    /**
     * @return the attack cooldown of a helicopter.
     */
    public int getHelicopterAttackCooldownTicks() {
        return helicopterAttackCooldownTicks;
    }

    /**
     * @return the amount of ticks to produce a helicopter on a factory.
     */
    public int getHelicopterProductionCost() {
        return helicopterProductionCost;
    }

    /**
     * @return the maximal durability of a fighter.
     */
    public int getFighterDurability() {
        return fighterDurability;
    }

    /**
     * @return the maximal speed of a fighter.
     */
    public double getFighterSpeed() {
        return fighterSpeed;
    }

    /**
     * @return the base vision range of a fighter.
     */
    public double getFighterVisionRange() {
        return fighterVisionRange;
    }

    /**
     * @return the attack range of a fighter against ground targets.
     */
    public double getFighterGroundAttackRange() {
        return fighterGroundAttackRange;
    }

    /**
     * @return the attack range of a fighter against aerial targets.
     */
    public double getFighterAerialAttackRange() {
        return fighterAerialAttackRange;
    }

    /**
     * @return the attack damage of a fighter against ground targets.
     */
    public int getFighterGroundDamage() {
        return fighterGroundDamage;
    }

    /**
     * @return the attack damage of a fighter against aerial targets.
     */
    public int getFighterAerialDamage() {
        return fighterAerialDamage;
    }

    /**
     * @return the defence of a fighter against ground attacks.
     */
    public int getFighterGroundDefence() {
        return fighterGroundDefence;
    }

    /**
     * @return the defence of a fighter against aerial attacks.
     */
    public int getFighterAerialDefence() {
        return fighterAerialDefence;
    }

    /**
     * @return the attack cooldown of a fighter.
     */
    public int getFighterAttackCooldownTicks() {
        return fighterAttackCooldownTicks;
    }

    /**
     * @return the amount of ticks to produce a fighter on a factory.
     */
    public int getFighterProductionCost() {
        return fighterProductionCost;
    }

    /**
     * @return the maximal possible amount of facility capture points.
     */
    public double getMaxFacilityCapturePoints() {
        return maxFacilityCapturePoints;
    }

    /**
     * @return the speed of facility capturing per each vehicle inside the facility area.
     */
    public double getFacilityCapturePointsPerVehiclePerTick() {
        return facilityCapturePointsPerVehiclePerTick;
    }

    /**
     * @return the width of facility area.
     */
    public double getFacilityWidth() {
        return facilityWidth;
    }

    /**
     * @return the height of facility area.
     */
    public double getFacilityHeight() {
        return facilityHeight;
    }

    /**
     * @return the base cooldown of tactical nuclear strike request.
     */
    public int getBaseTacticalNuclearStrikeCooldown() {
        return baseTacticalNuclearStrikeCooldown;
    }

    /**
     * @return the cooldown decrease of tactical nuclear strike request per each captured control center.
     */
    public int getTacticalNuclearStrikeCooldownDecreasePerControlCenter() {
        return tacticalNuclearStrikeCooldownDecreasePerControlCenter;
    }

    /**
     * @return the damage in the center of a nuclear explosion.
     */
    public double getMaxTacticalNuclearStrikeDamage() {
        return maxTacticalNuclearStrikeDamage;
    }

    /**
     * @return the radius of a nuclear explosion.
     */
    public double getTacticalNuclearStrikeRadius() {
        return tacticalNuclearStrikeRadius;
    }

    /**
     * @return the delay between the request of tactical nuclear strike and the nuclear explosion.
     */
    public int getTacticalNuclearStrikeDelay() {
        return tacticalNuclearStrikeDelay;
    }
}
