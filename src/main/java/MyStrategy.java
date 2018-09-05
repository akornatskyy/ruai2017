import model.ActionType;
import model.Game;
import model.Move;
import model.Player;
import model.World;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;

public final class MyStrategy implements Strategy {

  private static final int TICKS_PER_MOVE = 5;

  private final Queue<Consumer<Move>> delayedMoves = new ArrayDeque<>();

  @Override
  public void move(Player me, World world, Game game, Move move) {
    if (world.getTickIndex() % TICKS_PER_MOVE != 0) {
      return;
    }

    if (executeDelayedMove(move)) {
      return;
    }

    executeDelayedMove(move);
  }

  private boolean executeDelayedMove(Move move) {
    do {
      Consumer<Move> delayedMove = delayedMoves.poll();
      if (delayedMove == null) {
        return false;
      }

      delayedMove.accept(move);
    } while (move.getAction() == ActionType.NONE);

    return true;
  }
}
