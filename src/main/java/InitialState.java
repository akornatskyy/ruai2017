import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public final class InitialState implements State {

  private static final Logger LOGGER = Logger.get(InitialState.class);

  private final Context context;

  public InitialState(Context context) {
    this.context = context;
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
    LOGGER.log("populating moves");

    queue.add(m -> context.setState(new CombatState(context)));
  }
}