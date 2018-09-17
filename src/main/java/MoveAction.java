import model.ActionType;
import model.Move;
import model.VehicleType;

import java.util.function.Consumer;

public final class MoveAction {

  private static final Logger LOGGER = Logger.get(MoveAction.class);

  private static int selectedGroupId = -1;

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
      move.setGroup(group.getGroupId() + 1);
      move.setFactor(0.1);
      move.setX(v.x);
      move.setY(v.y);
    };
  }

  public static Consumer<Move> select(VehicleGroup group) {
    return move -> {
      int groupId = group.getGroupId() + 1;
      if (selectedGroupId == groupId) {
        return;
      }

      selectedGroupId = groupId;
      move.setAction(ActionType.CLEAR_AND_SELECT);
      move.setGroup(groupId);
    };
  }

  public static Consumer<Move> move(VehicleGroup group) {
    return move -> {
      Vector center = group.getCenter();
      Vector target = group.getTarget();

      move.setAction(ActionType.MOVE);
      move.setGroup(group.getGroupId() + 1);
      move.setX(target.x - center.x);
      move.setY(target.y - center.y);
    };
  }
}