import model.Move;
import model.Vehicle;
import model.VehicleType;

import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InitialState implements State {

  private static final Logger LOGGER = Logger.get(InitialState.class);

  private final Context context;

  public InitialState(Context context) {
    this.context = context;
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
    LOGGER.log("populating moves");

    Stream.of(VehicleType.values())
        .forEach(vehicleType -> {
          queue.add(MoveAction.select(vehicleType));
          queue.add(move -> {
            int groupId = vehicleType.ordinal();
            VehicleMap ally = context.getAlly();
            VehicleGroup group = new VehicleGroup(
                groupId,
                ally.getVehicles().stream()
                    .filter(Vehicle::isSelected)
                    .collect(Collectors.toList()));
            ally.getGroups().add(group);

            LOGGER.log("added selected vehicles to group %s", group);
          });
          queue.add(MoveAction.assign(vehicleType));
        });

    queue.add(m -> context.setState(new CombatState(context)));
  }
}