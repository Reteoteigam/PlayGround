package fight.model.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import fight.model.Creature;
import fight.model.Hero;
import fight.model.SimulationContext;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Context {

  public static final String DATAKEY_ATTACKER = "DATAKEY_ATTACKER";
  public static final String DATAKEY_DEFENDER = "DATAKEY_DEFENDER";
  private static ObservableList<Creature> creatures;

  private static List<Hero> players = new ArrayList<>();

  private static SimulationContext simulationContext = new SimulationContext();

  public static void addCreatures(List<Creature> creatures) {
    Context.creatures = FXCollections.observableArrayList(creatures);
  }

  public static ObservableList<Creature> getCreatures() {
    return creatures;
  }

  public static List<Hero> getPlayers() {

    return Context.players;

  }

  public static void addPlayer(Hero player) {

    Context.players.add(player);

  }

  public static Hero getPlayer(String datakeyAttacker) {
    Predicate<? super Hero> predicate = new Predicate<Hero>() {

      @Override
      public boolean test(Hero t) {
        return t.getKey().equalsIgnoreCase(datakeyAttacker);

      }
    };
    return players.stream().filter(predicate).findFirst().get();
  }

  public static SimulationContext getSimulationContext() {
    return simulationContext;
  }

}
