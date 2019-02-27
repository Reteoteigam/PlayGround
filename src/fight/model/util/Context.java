package fight.model.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import fight.model.Creature;
import fight.model.Horde;
import fight.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Context {

  public static final String DATAKEY_ATTACKER = "DATAKEY_ATTACKER";
  public static final String DATAKEY_DEFENDER = "DATAKEY_DEFENDER";
  private static ObservableList<Creature> creatures;

  private static List<Player> players = new ArrayList<>();

  public static void addCreatures(List<Creature> creatures) {
    Context.creatures = FXCollections.observableArrayList(creatures);
  }

  public static ObservableList<Creature> getCreatures() {
    return creatures;
  }

  public static List<Player> getPlayers() {

    return Context.players;

  }

  public static void addPlayer(Player player) {

    Context.players.add(player);

  }

  public static Player getPlayer(String datakeyAttacker) {
    Predicate<? super Player> predicate = new Predicate<Player>() {

      @Override
      public boolean test(Player t) {
        return t.getType().equalsIgnoreCase(datakeyAttacker);

      }
    };
    return players.stream().filter(predicate).findFirst().get();
  }

}
