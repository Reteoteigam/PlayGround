package fight.model.util;

import java.util.HashMap;
import java.util.List;

import org.junit.platform.commons.util.CollectionUtils;

import fight.model.Creature;
import fight.model.Horde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStorage {

  public static final String DATAKEY_ATTACKER = "DATAKEY_ATTACKER";
  private static ObservableList<Creature> creatures;

  private static HashMap<String, ObservableList<Horde>> hordeList = new HashMap<>();

  public static void addCreatures(List<Creature> creatures) {
    DataStorage.creatures = FXCollections.observableArrayList(creatures);
  }

  public static ObservableList<Creature> getCreatures() {
    return creatures;
  }

  public static void addHordeForAttacker(List<Horde> horde) {
    DataStorage.hordeList.put(DATAKEY_ATTACKER, FXCollections.observableArrayList(horde));

  }

  public static ObservableList<Horde> getHordeOf(String datakey) {
    return hordeList.get(datakey);
  }

}
