import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AttackTest {

  @DataProvider
  public static Object[][] samples() {
    return new Object[][] {
        {group(10, 0, 0, 0, 0), group(10, 0, 0, 0, 0), 0},
        {group(10, 0, 0, 0, 0), group(0, 10, 0, 0, 0), 0},
        {group(10, 0, 0, 0, 0), group(0, 0, 10, 0, 0), -16.0},
        {group(10, 0, 0, 0, 0), group(0, 0, 0, 10, 0), -12.0},
        {group(10, 0, 0, 0, 0), group(0, 0, 0, 0, 10), -10.0},

        {group(0, 50, 0, 0, 0), group(0, 50, 0, 0, 0), 0},
        {group(0, 50, 0, 0, 0), group(0, 40, 0, 0, 0), 11.6},
        {group(0, 50, 0, 0, 0), group(0, 30, 0, 0, 0), 11.1},
        {group(0, 50, 0, 0, 0), group(0, 20, 0, 0, 0), 6.5},
        {group(0, 5, 0, 0, 0), group(0, 4, 0, 0, 0), 1.2},

        {group(0, 50, 0, 0, 0), group(0, 0, 50, 0, 0), 50.0},
        {group(0, 50, 0, 0, 0), group(0, 0, 60, 0, 0), 74.8},

        {group(0, 50, 10, 0, 0), group(0, 60, 0, 0, 0), 22.9},
        {group(0, 0, 0, 0, 10), group(0, 0, 0, 10, 0), 9.1},

        {group(0, 0, 50, 0, 0), group(0, 0, 0, 0, 50), 43.2},
        {group(0, 0, 50, 0, 0), group(0, 0, 0, 2, 0), -0.1},
        {group(0, 0, 20, 0, 0), group(0, 0, 0, 2, 0), -0.28},
        {group(0, 0, 10, 0, 0), group(0, 0, 0, 2, 0), -0.6},
        {group(0, 0, 10, 0, 0), group(0, 0, 0, 1, 0), -0.1},
        {group(0, 0, 4, 0, 0), group(0, 0, 0, 1, 0), -0.2},
        {group(0, 0, 3, 0, 0), group(0, 0, 0, 1, 0), -0.4},

        {group(0, 0, 0, 30, 0), group(0, 0, 0, 1, 0), 0.5},
        {group(0, 0, 0, 3, 0), group(0, 0, 0, 1, 0), 0.4},
        {group(0, 0, 0, 10, 0), group(0, 0, 0, 0, 2), -3.8},
        {group(0, 0, 0, 5, 0), group(0, 0, 0, 0, 2), -4.4},

        {group(0, 0, 0, 0, 10), group(2, 0, 0, 0, 8), -2.5}
    };
  }

  @Test(dataProvider = "samples")
  public void testAdvantage(
      VehicleGroup attacker, VehicleGroup defender, double expected) {
    double advantage = Attack.gain(attacker, defender);

    Assert.assertEquals(advantage, expected, 0.1);
  }

  private static VehicleGroup group(int... counts) {
    return Samples.group(0, Samples.vehicles(counts));
  }
}