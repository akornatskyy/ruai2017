import model.Vehicle;
import model.VehicleType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class HealTest {
  @DataProvider
  public static Object[][] samples() {
    return new Object[][] {
        // no heal, number of damaged does not exceeds threshold
        {
            group(vehicles(4, VehicleType.ARRV, 100)),
            other(vehicles(8, VehicleType.FIGHTER, 100)),
            0
        },
        {
            group(vehicles(4, VehicleType.ARRV, 100)),
            other(vehicles(2, VehicleType.FIGHTER, 50),
                  vehicles(8, VehicleType.HELICOPTER, 100)),
            0
        },
        {
            group(vehicles(2, VehicleType.ARRV, 100)),
            other(vehicles(1, VehicleType.HELICOPTER, 75),
                  vehicles(9, VehicleType.FIGHTER, 100)),
            0
        },
        // not enough healers
        {
            group(vehicles(2, VehicleType.ARRV, 100)),
            other(vehicles(4, VehicleType.FIGHTER, 75),
                  vehicles(6, VehicleType.HELICOPTER, 100)),
            0
        },
        {
            group(vehicles(2, VehicleType.ARRV, 100)),
            other(vehicles(10, VehicleType.FIGHTER, 75)),
            0
        },
        // heals
        {
            group(vehicles(3, VehicleType.ARRV, 100)),
            other(vehicles(4, VehicleType.HELICOPTER, 75),
                  vehicles(6, VehicleType.FIGHTER, 100)),
            3
        },
        {
            group(vehicles(4, VehicleType.ARRV, 100)),
            other(vehicles(3, VehicleType.FIGHTER, 75),
                  vehicles(7, VehicleType.HELICOPTER, 100)),
            3
        },
        {
            group(vehicles(4, VehicleType.ARRV, 100)),
            other(vehicles(10, VehicleType.FIGHTER, 75)),
            4
        }
    };
  }

  @Test(dataProvider = "samples")
  public void testGain(
      VehicleGroup group, VehicleGroup other, double expected) {

    double gain = Heal.gain(group, other);

    Assert.assertEquals(gain, expected, 0.1);

    gain = Heal.gain(other, group);

    Assert.assertEquals(gain, expected, 0.1);
  }

  private static Vehicle[] vehicles(
      int number, VehicleType type, int durability) {
    return IntStream.range(0, number)
        .mapToObj(i -> new Vehicle(
            i, 0, 0, 0, 0, durability, 100, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, type, false, false, new int[] {}))
        .toArray(Vehicle[]::new);
  }

  private static VehicleGroup group(Vehicle[]... vehicles) {
    return Samples.group(0, merge(vehicles));
  }

  private static VehicleGroup other(Vehicle[]... vehicles) {
    return Samples.group(1, merge(vehicles));
  }

  private static List<Vehicle> merge(Vehicle[]... vehicles) {
    return Stream.of(vehicles)
        .flatMap(Stream::of)
        .collect(Collectors.toList());
  }
}