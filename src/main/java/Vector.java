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

  public void set(Vector other) {
    this.x = other.x;
    this.y = other.y;
  }

  public void add(Vector other) {
    x += other.x;
    y += other.y;
  }

  public void sub(Vector other) {
    x -= other.x;
    y -= other.y;
  }

  public double len() {
    return Math.sqrt(x * x + y * y);
  }

  public double len(Vector other) {
    double dx = x - other.x;
    double dy = y - other.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double len2(double x, double y) {
    double dx = x - this.x;
    double dy = y - this.y;
    return dx * dx + dy * dy;
  }

  public void norm() {
    double l = len();
    if (l != 0) {
      x /= l;
      y /= l;
    }
  }

  public void scl(double scalar) {
    x *= scalar;
    y *= scalar;
  }

  @Override
  public String toString() {
    return String.format("(%.2f, %.2f)", x, y);
  }
}