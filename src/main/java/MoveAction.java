import model.ActionType;
import model.Move;
import model.VehicleType;

import java.util.function.Consumer;

public final class MoveAction {
  private static final Logger LOGGER = Logger.get(MoveAction.class);

  public static Consumer<Move> select(VehicleType type) {
    return move -> {
      LOGGER.log("select: %s", type);

      move.setAction(ActionType.CLEAR_AND_SELECT);
      move.setVehicleType(type);
      move.setBottom(1024);
      move.setRight(1024);
    };
  }

  public static Consumer<Move> assign(VehicleType type) {
    return move -> {
      LOGGER.log("assign group: %s", type);

      move.setAction(ActionType.ASSIGN);
      move.setGroup(type.ordinal() + 1);
    };
  }
}
