import model.Move;

import java.util.Queue;
import java.util.function.Consumer;

public final class FormationState implements State {

  private static final Logger LOGGER = Logger.get(FormationState.class);

  private static final int MAX_NUMBER_OF_MOVES = 60;

  private final Context context;
  private final Steering steering;

  private long totalNumberOfMoves;

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
    long numberOfMoves = context.getAlly().getGroups().stream()
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
    totalNumberOfMoves += numberOfMoves;
    if (numberOfMoves == 0 || totalNumberOfMoves >= MAX_NUMBER_OF_MOVES) {
      if (LOGGER.isEnabled()) {
        LOGGER.log("number of moves: %d, total: %d",
                   numberOfMoves, totalNumberOfMoves);
      }

      context.setState(new CombatState(context));
    }
  }
}