public interface Estimator {
  default void update() {
  }

  double calc(VehicleGroup group, Vector target);
}