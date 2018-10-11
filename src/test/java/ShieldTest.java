import model.VehicleType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class ShieldTest {
  @DataProvider
  public static Object[][] samples() {
    return new Object[][] {
        // no shields
        {
            group(50, VehicleType.FIGHTER),
            group(80, VehicleType.HELICOPTER),
            0
        },
        {
            group(4, VehicleType.TANK),
            group(9, VehicleType.IFV),
            0
        },
        {
            group(8, VehicleType.ARRV),
            group(4, VehicleType.IFV),
            0
        },
        {
            group(50, VehicleType.IFV),
            group(80, VehicleType.HELICOPTER),
            0
        },
        // shields
        {
            group(50, VehicleType.HELICOPTER),
            group(80, VehicleType.IFV),
            4e-10
        }
    };
  }

  @Test(dataProvider = "samples")
  public void testGain(
      VehicleGroup group, VehicleGroup other, double expected) {

    double gain = Shield.gain(group, other);

    Assert.assertEquals(gain, expected);
  }

  private static VehicleGroup group(int number, VehicleType type) {
    return Samples.group(0, Samples.vehicles(number, type));
  }
}