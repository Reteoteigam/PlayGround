package fight.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fight.model.Creature;
import fight.model.Horde;
import fight.model.Hero;
import fight.model.SimulationContext;
import fight.model.util.Context;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import utils.logger.MyLogger;

public class SimulationContextCreator {

  private static final MyLogger LOGGER = MyLogger.getLogger(SimulationContextCreator.class);

  public static SimulationContext create() {
    LOGGER.debug("simulate start");

    SimulationContext simulationContext = new SimulationContext();

    ObservableList<Creature> creatures = Context.getCreatures();
    ObservableMap<String, Creature> newCreatures = deepCopyForInitialValuesFor(creatures);
    simulationContext.setCreatures(newCreatures);

    Hero attacker = Context.getPlayer(Context.DATAKEY_ATTACKER);
    ObservableMap<String, Creature> creaturesBaseValue = simulationContext.getCreatures();
    attacker.set(creaturesBaseValue);
    Opponent opponentA = deepCopyForInitialValues(attacker);
    simulationContext.setAttacker(opponentA);

    Hero defender = Context.getPlayer(Context.DATAKEY_DEFENDER);
    ObservableMap<String, Creature> creaturesBaseValue2 = simulationContext.getCreatures();
    defender.set(creaturesBaseValue2);
    Opponent opponentD = deepCopyForInitialValues(defender);
    simulationContext.setDefender(opponentD);

    return simulationContext;

  }

  private static Opponent deepCopyForInitialValues(Hero source) {

    ObservableList<Horde> sourceHorde = source.getHorde();
    ArrayList<Horde> newHorde = new ArrayList<>();
    for (Horde sourceElement : sourceHorde) {

      Horde newElement = new Horde();
      newElement.setCreature(sourceElement.getCreature());
      newElement.setAmount(sourceElement.getAmount());
      newHorde.add(newElement);
    }
    String sourceType = source.getKey();
    ObservableMap<String, Creature> creaturesBaseValue = source.getCreaturesBaseValue();
    Opponent newPlayer = new Opponent(sourceType, creaturesBaseValue, newHorde);
    return newPlayer;

  }

  private static ObservableMap<String, Creature> deepCopyForInitialValuesFor(List<Creature> oldCreatures) {

    HashMap<String, Creature> newHorde = new HashMap<String, Creature>();
    for (Creature oldCreature : oldCreatures) {
      Creature newResult = new Creature()
          .setName(oldCreature.getName())
          .setAttack(oldCreature.getAttack())
          .setDefense(oldCreature.getDefense())
          .setLife(oldCreature.getLife())
          .setVelocity(oldCreature.getVelocity())
          .setCapacity(oldCreature.getCapacity())
          .setPoint(oldCreature.getPoint())
          .setHerbEssences(oldCreature.getHerbEssences())
          .setCrystalSplinters(oldCreature.getCrystalSplinters())
          .setPowerStones(oldCreature.getPowerStones())
          .setGoldResin(oldCreature.getGoldResin())
          .setMana(oldCreature.getMana());
      newHorde.put(newResult.getName(), newResult);
    }

    return FXCollections.observableMap(newHorde);

  }

}
