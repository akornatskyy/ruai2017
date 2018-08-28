package model;

/**
 * The instance of this class contains all the data about player's state.
 */
public class Player {
    private final long id;
    private final boolean me;
    private final boolean strategyCrashed;
    private final int score;
    private final int remainingActionCooldownTicks;
    private final int remainingNuclearStrikeCooldownTicks;
    private final long nextNuclearStrikeVehicleId;
    private final int nextNuclearStrikeTickIndex;
    private final double nextNuclearStrikeX;
    private final double nextNuclearStrikeY;

    public Player(
            long id, boolean me, boolean strategyCrashed, int score, int remainingActionCooldownTicks,
            int remainingNuclearStrikeCooldownTicks, long nextNuclearStrikeVehicleId, int nextNuclearStrikeTickIndex,
            double nextNuclearStrikeX, double nextNuclearStrikeY) {
        this.id = id;
        this.me = me;
        this.strategyCrashed = strategyCrashed;
        this.score = score;
        this.remainingActionCooldownTicks = remainingActionCooldownTicks;
        this.remainingNuclearStrikeCooldownTicks = remainingNuclearStrikeCooldownTicks;
        this.nextNuclearStrikeVehicleId = nextNuclearStrikeVehicleId;
        this.nextNuclearStrikeTickIndex = nextNuclearStrikeTickIndex;
        this.nextNuclearStrikeX = nextNuclearStrikeX;
        this.nextNuclearStrikeY = nextNuclearStrikeY;
    }

    /**
     * @return the unique player ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return {@code true} if and only if this is your player.
     */
    public boolean isMe() {
        return me;
    }

    /**
     * @return {@code true} if and only if the strategy of this player is crashed.
     */
    public boolean isStrategyCrashed() {
        return strategyCrashed;
    }

    /**
     * @return the amount of score points.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the amount of ticks remaining before any next action. If this value is {@code 0}, then the player may
     * perform an action in the current tick.
     */
    public int getRemainingActionCooldownTicks() {
        return remainingActionCooldownTicks;
    }

    /**
     * @return the amount of ticks remaining before next tactical nuclear strike request. If this value is {@code 0},
     * then the player may request a nuclear strike in the current tick.
     */
    public int getRemainingNuclearStrikeCooldownTicks() {
        return remainingNuclearStrikeCooldownTicks;
    }

    /**
     * @return the nuclear strike spotter vehicle ID or {@code -1}.
     */
    public long getNextNuclearStrikeVehicleId() {
        return nextNuclearStrikeVehicleId;
    }

    /**
     * @return the tick index of this player's next nuclear strike or {@code -1}.
     */
    public int getNextNuclearStrikeTickIndex() {
        return nextNuclearStrikeTickIndex;
    }

    /**
     * @return the X of this player's next nuclear strike or {@code -1.0}.
     */
    public double getNextNuclearStrikeX() {
        return nextNuclearStrikeX;
    }

    /**
     * @return the Y of this player's next nuclear strike or {@code -1.0}.
     */
    public double getNextNuclearStrikeY() {
        return nextNuclearStrikeY;
    }
}
