package fight.model.util;

import java.util.HashMap;

import fight.model.Creature;
import javafx.collections.ObservableList;

public class DataStorage {

  public static final String DATAKEY_ATTACKER = "DATAKEY_ATTACKER";
  private static HashMap<String, ObservableList<Creature>> heroes = new HashMap<>();

  public static ObservableList<Creature> getCreatureOf(String name) {

    return heroes.get(name);

  }

  public static void addCreatureFor(String name, Creature creature) {
    heroes.get(name).add(creature);

  }

}
