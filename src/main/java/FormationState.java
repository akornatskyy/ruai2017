import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public final class FormationState implements State {

  private static final Logger LOGGER = Logger.get(FormationState.class);

  private final Context context;
  private final Steering steering;

  public FormationState(Context context) {
    this.context = context;
    this.steering = new Steering(
        new FormationEstimator(context.getAlly().getGroups()));
  }

  @Override
  public void update() {
    context.getAlly().getGroups().forEach(VehicleGroup::update);
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
    long c = context.getAlly().getGroups().stream()
        .filter(group -> {
          Vector target = steering.seekTarget(group);
          group.setTarget(target);
          if (target != null) {
            queue.add(MoveAction.select(group));
            queue.add(MoveAction.move(group));
            return true;
          }

          return false;
        })
        .count();
    if (c == 0) {
      if (LOGGER.isEnabled()) {
        LOGGER.log("done");
      }

      context.setState(new CombatState(context));
    }
  }
}