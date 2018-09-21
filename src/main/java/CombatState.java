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
  private final Estimator estimator;
  private final Steering steering;

  public CombatState(Context context) {
    this.context = context;
    this.estimator = new CombatEstimator(
        context.getAlly().getGroups(),
        context.getEnemy().getGroups());
    this.steering = new Steering(estimator);
  }

  @Override
  public void update() {
    context.getAlly().getGroups().forEach(VehicleGroup::update);
  }

  @Override
  public void moves(Queue<Consumer<Move>> queue) {
    Collection<VehicleGroup> groups = clusterEnemyVehicles();

    estimator.update();

    context.getAlly().getGroups().stream()
        .filter(VehicleGroup::isAlive)
        .forEach(group -> {
          Vector target = steering.seekTarget(group);
          if (target != null) {
            if (LOGGER.isEnabled()) {
              LOGGER.log("%s %s -> %s", group, group.getCenter(), target);
            }

            group.setTarget(target);
            queue.add(MoveAction.select(group));
            queue.add(MoveAction.move(group));
          } else {
            if (LOGGER.isEnabled()) {
              LOGGER.log("%s no target", group);
            }
          }
        });

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

    if (LOGGER.isEnabled()) {
      LOGGER.log("clustered enemy groups: %s", vehicleMap);
    }

    return groups;
  }
}