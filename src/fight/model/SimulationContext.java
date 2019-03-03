package fight.model;

import fight.calculation.Opponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class SimulationContext {

  private Opponent attacker;

  private Opponent defender;

  private ObservableMap<String, Creature> creatures = FXCollections.emptyObservableMap();

  public Opponent getAttacker() {
    return attacker;
  }

  public void setAttacker(Opponent attacker) {
    this.attacker = attacker;
  }

  public Opponent getDefender() {
    return defender;
  }

  public void setDefender(Opponent defender) {
    this.defender = defender;
  }

  public ObservableMap<String, Creature> getCreatures() {
    return creatures;
  }

  public void setCreatures(ObservableMap<String, Creature> creatures) {
    this.creatures = creatures;
  }

}
