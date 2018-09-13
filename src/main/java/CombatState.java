import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public final class CombatState implements State {

  private final Context context;

  public CombatState(Context context) {
    this.context = context;
  }

  @Override
  public void update() {
    context.getAlly().getGroups().forEach(VehicleGroup::update);
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
  }
}