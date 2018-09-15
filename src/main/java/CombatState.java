import model.Move;
import model.Vehicle;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public final class CombatState implements State {

  private static final Logger LOGGER = Logger.get(CombatState.class);

  private static final ConnectedLabeler<Vehicle> LABELER =
      new ConnectedLabeler<>(Vehicle::getX, Vehicle::getY, 8);

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
    Collection<VehicleGroup> groups = clusterEnemyVehicles();

    // TODO:

    groups.clear();
  }

  private Collection<VehicleGroup> clusterEnemyVehicles() {
    VehicleMap vehicleMap = context.getEnemy();
    Collection<VehicleGroup> groups = vehicleMap.getGroups();
    List<List<Vehicle>> grouped = LABELER.grouped(vehicleMap.getVehicles());
    for (int i = 0; i < grouped.size(); i++) {
      VehicleGroup group = new VehicleGroup(i, grouped.get(i));
      group.update();
      groups.add(group);
    }

    LOGGER.log("clustered enemy groups: %s", vehicleMap);

    return groups;
  }
}