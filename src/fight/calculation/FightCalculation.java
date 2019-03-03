package fight.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.function.Function;

import fight.model.Creature;
import fight.model.Horde;
import fight.model.SimulationContext;
import javafx.collections.ObservableMap;
import utils.logger.MyLogger;

public class FightCalculation {

  private static final MyLogger LOGGER = MyLogger.getLogger(FightCalculation.class);
  private static final MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

  public static SimulationContext oneStep(SimulationContext simulationContext) {

    bla(simulationContext);
    return simulationContext;

  }

  private static void bla(SimulationContext simulationContext) {
    LOGGER.debug("ROUND START ################## ");

    Opponent attacker = simulationContext.getAttacker();
    ArrayList<Horde> currentHorde = attacker.getCurrentHorde();
    BigDecimal initialLife = attacker.getInitialLife();

  }

  // public static BigDecimal sumAttack(Opponent opponent) {
//
//  BigDecimal result = opponent.getCurrentHorde().stream()
//      .map(calculateAttack(opponent.getCreaturesBaseValue()))
//      .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//  return result;
//}
//
//private static Function<Horde, BigDecimal> calculateAttack(ObservableMap<String, Creature> creatures) {
//
//  return new Function<Horde, BigDecimal>() {
//
//    @Override
//    public BigDecimal apply(Horde t) {
//      BigDecimal multiply = creatures
//          .get(t.getCreature())
//          .getAttack()
//          .multiply(t.getAmount());
//      return multiply;
//    }
//  };
//
//}
//
//public static BigDecimal sumDefense(Opponent opponent) {
//  System.out.println(opponent);
//  BigDecimal result = opponent.getCurrentHorde().stream()
//      .map(calculateDefense(opponent.getCreaturesBaseValue()))
//      .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//  return result;
//}
//
//private static Function<Horde, BigDecimal> calculateDefense(ObservableMap<String, Creature> creatures) {
//
//  return new Function<Horde, BigDecimal>() {
//
//    @Override
//    public BigDecimal apply(Horde t) {
//      BigDecimal multiply = creatures
//          .get(t.getCreature())
//          .getDefense()
//          .multiply(t.getAmount());
//      return multiply;
//
//    }
//  };
//
//}

  public static BigDecimal sumLife(Opponent opponent) {

    BigDecimal result = opponent.getCurrentHorde().stream()
        .map(calculateLife(opponent.getCreaturesBaseValue()))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return result;
  }

  private static Function<Horde, BigDecimal> calculateLife(ObservableMap<String, Creature> creatures) {

    return new Function<Horde, BigDecimal>() {

      @Override
      public BigDecimal apply(Horde t) {
        return creatures
            .get(t.getCreature())
            .getLife()
            .multiply(t.getAmount());
      }
    };

  }
}
