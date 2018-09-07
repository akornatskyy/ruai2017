import model.Vehicle;
import model.VehicleUpdate;
import model.World;

public final class Context {

  private static final Logger LOGGER = Logger.get(Context.class);

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

  public void update(World world) {
  }
}