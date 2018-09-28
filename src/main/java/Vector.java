public final class Vector {
  public double x;
  public double y;

  public void set(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public double len(Vector other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String toString() {
    return String.format("(%.2f, %.2f)", x, y);
  }
}