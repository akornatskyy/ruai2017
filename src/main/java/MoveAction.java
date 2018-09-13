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

  public static Consumer<Move> scaleIn(VehicleGroup group) {
    return move -> {
      LOGGER.log("scale in: %s", group);

      Vector v = group.getCenter();

      move.setAction(ActionType.SCALE);
      move.setFactor(0.1);
      move.setX(v.x);
      move.setY(v.y);
      move.setGroup(group.getGroupId() + 1);
    };
  }
}