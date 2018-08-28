import model.*;

/**
 * This interface contains the methods that each strategy should implement.
 */
public interface Strategy {
    /**
     * Main strategy method, controlling the vehicles.
     * The game engine calls this method once each time tick.
     *
     * @param me    the owner player of this strategy.
     * @param world the current world snapshot.
     * @param game  many game constants.
     * @param move  the object that encapsulates all strategy instructions.
     */
    void move(Player me, World world, Game game, Move move);
}
