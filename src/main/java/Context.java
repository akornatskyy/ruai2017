import model.Vehicle;
import model.VehicleUpdate;
import model.World;

public final class Context {

  private static final Logger LOGGER = Logger.get(Context.class);

  private final VehicleMap ally = new VehicleMap();
  private final VehicleMap enemy = new VehicleMap();

  private State state;

  public Context() {
    setState(new InitialState(this));
  }

  public State getState() {
    return state;
  }

  void setState(State state) {
    LOGGER.log("activated " + state.getClass().getName());
    this.state = state;
  }

  public VehicleMap getAlly() {
    return ally;
  }

  public void update(World world) {
    long playerId = world.getMyPlayer().getId();
    for (Vehicle vehicle : world.getNewVehicles()) {
      if (vehicle.getPlayerId() == playerId) {
        ally.add(vehicle);
      } else {
        enemy.add(vehicle);
      }
    }

    for (VehicleUpdate u : world.getVehicleUpdates()) {
      if (!ally.update(u)) {
        enemy.update(u);
      }
    }
  }
}