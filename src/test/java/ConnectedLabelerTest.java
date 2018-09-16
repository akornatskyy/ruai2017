import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ConnectedLabelerTest {

  @DataProvider
  public static Object[][] samples() {
    return new Object[][] {
        {
            1,
            points(new double[][] {}),
            groups(new double[][][] {})
        },
        {
            1,
            points(new double[][] {
                {1},
                {0}
            }),
            groups(new double[][][] {
                {
                    {0, 0}
                }
            })
        },
        {
            1,
            points(new double[][] {
                {1, 0},
                {0, 1}
            }),
            groups(new double[][][] {
                {
                    {0, 0}, {1, 1}
                }
            })
        },
        {
            1,
            points(new double[][] {
                {0, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0}
            }),
            groups(new double[][][] {
                {
                    {1, 0}, {0, 1}, {1, 1}
                },
                {
                    {4, 0}, {3, 1}, {3, 2}, {4, 2}, {4, 3}
                },
                {
                    {6, 1}
                },
                {
                    {1, 3}, {1, 4}, {2, 4}, {2, 5}
                },
                {
                    {5, 5}
                }
            })
        },
        {
            2,
            points(new double[][] {
                {0, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0}
            }),
            groups(new double[][][] {
                {
                    {4, 0}, {1, 0}, {0, 1}, {1, 1}, {3, 1}, {6, 1}, {3, 2},
                    {4, 2}, {4, 3}, {1, 3}, {1, 4}, {2, 4}, {2, 5}, {5, 5}
                }
            })
        },
        {
            2,
            points(new double[][] {
                {0, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0}
            }),
            groups(new double[][][] {
                {
                    {1, 0}, {0, 1}, {1, 1}
                },
                {
                    {4, 0}, {6, 1}
                },
                {
                    {1, 4}, {2, 5}, {5, 5}
                }
            })
        },
        {
            3,
            points(new double[][] {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1}
            }),
            groups(new double[][][] {
                {
                    {1, 0}, {0, 1}, {1, 1}, {2, 3}
                },
                {
                    {6, 1}, {6, 5}
                }
            })
        }
    };
  }

  @Test(dataProvider = "samples")
  public void testGrouped(
      int tileSize, List<Point> units, List<List<Point>> expected) {
    ConnectedLabeler<Point> labeler = new ConnectedLabeler<>(
        p -> p.x, p -> p.y, tileSize);

    List<List<Point>> grouped = labeler.grouped(units);

    Assert.assertEquals(grouped, expected);
  }

  private static List<Point> points(double[][] matrix) {
    List<Point> points = new ArrayList<>();
    for (int y = 0; y < matrix.length; y++) {
      double[] raw = matrix[y];
      for (int x = 0; x < raw.length; x++) {
        if (raw[x] != 0) {
          points.add(new Point(x, y));
        }
      }
    }

    return points;
  }

  private static List<List<Point>> groups(double[][][] data) {
    return Stream.of(data)
        .map(points -> Stream.of(points)
            .map(p -> new Point(p[0], p[1]))
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  private static class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "{" + (int) x + ", " + (int) y + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Point point = (Point) o;
      return Double.compare(point.x, x) == 0 &&
             Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}