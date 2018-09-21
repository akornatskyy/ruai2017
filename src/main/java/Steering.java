public final class Steering {

  private final Estimator estimator;

  public Steering(Estimator estimator) {
    this.estimator = estimator;
  }

  public Vector seekTarget(VehicleGroup group) {
    Vector center = group.getCenter();
    double p = estimator.calc(group, center);
    return null;
  }
}