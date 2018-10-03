import model.VehicleType;

public final class Attack {

  private static final Logger LOGGER = Logger.get(Attack.class, true);

  // attack - defense
  private static final double[][] ADVANTAGE = new double[][]
      {
          {0, 0, 0, 0, 0},
          {0, 30, 60, 0, 0},
          {80, 10, 40, 20, 40},
          {40, 10, 40, 30, 10},
          {50, 0, 20, 40, 20}
      };

  /**
   * Returns gain over defender in number of vehicles.
   */
  public static double gain(VehicleGroup attacker, VehicleGroup defender) {
    int ah = attacker.getHealth();
    if (ah == 0) {
      return 0;
    }

    int dh = defender.getHealth();
    if (dh == 0) {
      return 0;
    }

    if (LOGGER.isEnabled()) {
      LOGGER.log("gain: %s vs %s", attacker, defender);
    }

    double ad = damage(attacker, defender);
    double dd = damage(defender, attacker);

    if (LOGGER.isEnabled()) {
      LOGGER.log("  health: %d [%.1f] vs %d [%.1f]",
                 ah, ad, dh, dd);
    }

    double ahc = ah, dhc = dh, adc = ad, ddc = dd;
    double ka = ad / ah, kd = dd / dh;
    int n = 0;
    while (n < 30 && ahc >= 1 && dhc >= 1) {

      ahc -= ddc;
      dhc -= adc;

      adc = ka * ahc;
      ddc = kd * dhc;

      if (LOGGER.isEnabled()) {
        LOGGER.log("    remaining: %.1f (%.1f) vs %.1f (%.1f)",
                   ahc, ddc, dhc, adc);
      }

      n++;
    }

    // remaining
    //double ar = Math.max(0, attacker.size() * ahc / ah);
    //double dr = Math.max(0, defender.size() * dhc / dh);
    double ar = attacker.size() * ahc / ah;
    double dr = defender.size() * dhc / dh;

    if (LOGGER.isEnabled()) {
      LOGGER.log("  remaining: %.1f vs %.1f", ar, dr);
    }

    // loses
    double al = attacker.size() - ar;
    double dl = defender.size() - dr;

    if (LOGGER.isEnabled()) {
      LOGGER.log("  loses: %.1f vs %.1f", al, dl);
    }

    // 1 score point is given for the destruction of the defender unit.
    double r = dl - al;

    if (LOGGER.isEnabled()) {
      LOGGER.log("  %.1f (%d)", r, n);
    }

    return r;
  }

  private static double damage(VehicleGroup attacker, VehicleGroup defender) {

    int af = attacker.getCountOfType(VehicleType.FIGHTER);
    int ah = attacker.getCountOfType(VehicleType.HELICOPTER);
    int aat = af + ah;

    int df = defender.getCountOfType(VehicleType.FIGHTER);
    int dh = defender.getCountOfType(VehicleType.HELICOPTER);
    int dat = df + dh;

    int ai = attacker.getCountOfType(VehicleType.IFV);
    int at = attacker.getCountOfType(VehicleType.TANK);
    int agt = ai + at;

    int da = defender.getCountOfType(VehicleType.ARRV);
    int di = defender.getCountOfType(VehicleType.IFV);
    int dt = defender.getCountOfType(VehicleType.TANK);
    int dgt = da + di + dt;

    int nd = dat + dgt;

    double d = 0;
    if (aat > 0 && dat > 0) {
      double a = ADVANTAGE[VehicleType.FIGHTER.ordinal()][VehicleType.FIGHTER.ordinal()];
      d += Math.min(af, df) * a * df / dat;

      a = ADVANTAGE[VehicleType.FIGHTER.ordinal()][VehicleType.HELICOPTER.ordinal()];
      d += Math.min(af, dh) * a * dh / dat;

      a = ADVANTAGE[VehicleType.HELICOPTER.ordinal()][VehicleType.FIGHTER.ordinal()];
      d += Math.min(ah, df) * a * df / nd;

      a = ADVANTAGE[VehicleType.HELICOPTER.ordinal()][VehicleType.HELICOPTER.ordinal()];
      d += Math.min(ah, dh) * a * dh / nd;
    }

    if (aat > 0 && dgt > 0) {
      double a = ADVANTAGE[VehicleType.HELICOPTER.ordinal()][VehicleType.ARRV.ordinal()];
      d += Math.min(ah, da) * a * da / nd;

      a = ADVANTAGE[VehicleType.HELICOPTER.ordinal()][VehicleType.IFV.ordinal()];
      d += Math.min(ah, di) * a * di / nd;

      a = ADVANTAGE[VehicleType.HELICOPTER.ordinal()][VehicleType.TANK.ordinal()];
      d += Math.min(ah, dt) * a * dt / nd;
    }

    if (agt > 0 && dgt > 0) {
      double a = ADVANTAGE[VehicleType.IFV.ordinal()][VehicleType.ARRV.ordinal()];
      d += Math.min(ai, da) * a * da / nd;

      a = ADVANTAGE[VehicleType.IFV.ordinal()][VehicleType.IFV.ordinal()];
      d += Math.min(ai, di) * a * di / nd;

      a = ADVANTAGE[VehicleType.IFV.ordinal()][VehicleType.TANK.ordinal()];
      d += Math.min(ai, dt) * a * dt / nd;

      a = ADVANTAGE[VehicleType.TANK.ordinal()][VehicleType.ARRV.ordinal()];
      d += Math.min(at, da) * a * da / (dgt + dh);

      a = ADVANTAGE[VehicleType.TANK.ordinal()][VehicleType.IFV.ordinal()];
      d += Math.min(at, di) * a * di / (dgt + dh);

      a = ADVANTAGE[VehicleType.TANK.ordinal()][VehicleType.TANK.ordinal()];
      d += Math.min(at, dt) * a * dt / (dgt + dh);
    }

    if (agt > 0 && dat > 0) {
      double a = ADVANTAGE[VehicleType.IFV.ordinal()][VehicleType.FIGHTER.ordinal()];
      d += Math.min(ai, df) * a * df / nd;

      a = ADVANTAGE[VehicleType.IFV.ordinal()][VehicleType.HELICOPTER.ordinal()];
      d += Math.min(ai, dh) * a * dh / nd;

      if (dgt + dh > 0) {
        a = ADVANTAGE[VehicleType.TANK.ordinal()][VehicleType.HELICOPTER.ordinal()];
        d += Math.min(at, dh) * a * dh / (dgt + dh);
      }
    }

    return d;
  }
}