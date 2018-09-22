import java.util.List;

public final class FormationEstimator implements Estimator {

  private final List<VehicleGroup> allies;

  public FormationEstimator(List<VehicleGroup> allies) {
    this.allies = allies;
  }

  @Override
  public double calc(VehicleGroup group, Vector target) {
    double s = 0.0;
    for (VehicleGroup other : allies) {
      if (group != other) {
        s += attractive(group, target) + repulsive(group, other, target);
      }
    }

    return s;
  }

  private static double attractive(VehicleGroup group, Vector target) {
    return 0;
  }

  private static double repulsive(
      VehicleGroup group, VehicleGroup other, Vector target) {
    return 0;
  }
}