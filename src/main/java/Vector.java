public final class Vector {
  public double x;
  public double y;

  public static Vector scl(Vector source, double scalar) {
    Vector target = new Vector();
    target.set(source.x * scalar, source.y * scalar);
    return target;
  }

  public void set(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void add(Vector other) {
    x += other.x;
    y += other.y;
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