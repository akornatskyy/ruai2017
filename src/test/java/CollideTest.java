import model.VehicleType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CollideTest {
  @DataProvider
  public static Object[][] samples() {
    return new Object[][] {
        // air to air
        {
            group(4, VehicleType.FIGHTER),
            group(8, VehicleType.FIGHTER),
            -0.32
        },
        {
            group(20, VehicleType.FIGHTER),
            group(40, VehicleType.HELICOPTER),
            -8
        },
        {
            group(100, VehicleType.HELICOPTER),
            group(100, VehicleType.FIGHTER),
            -100
        },
        // ground to ground
        {
            group(10, VehicleType.ARRV),
            group(20, VehicleType.TANK),
            -2
        },
        {
            group(1, VehicleType.IFV),
            group(100, VehicleType.TANK),
            -1
        },
        // air to ground
        {
            group(4, VehicleType.FIGHTER),
            group(8, VehicleType.TANK),
            0
        },
        {
            group(2, VehicleType.IFV),
            group(10, VehicleType.HELICOPTER),
            0
        },
        {
            group(5, VehicleType.ARRV),
            group(7, VehicleType.FIGHTER),
            0
        }
    };
  }

  @Test(dataProvider = "samples")
  public void testLoss(
      VehicleGroup group, VehicleGroup other, double expected) {

    double loss = Collide.loss(group, other);

    Assert.assertEquals(loss, expected, 0.01);

    loss = Collide.loss(other, group);

    Assert.assertEquals(loss, expected, 0.01);
  }

  private static VehicleGroup group(int number, VehicleType type) {
    return Samples.group(0, Samples.vehicles(number, type));
  }
}