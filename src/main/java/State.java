import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public interface State {
  default void update() {
  }

  void moves(Queue<Consumer<Move>> queue);
}