import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public final class InitialState implements State {

  private final Context context;

  public InitialState(Context context) {
    this.context = context;
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
  }
}