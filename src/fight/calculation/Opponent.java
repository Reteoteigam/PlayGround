package fight.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;

import fight.model.Creature;
import fight.model.Horde;
import javafx.collections.ObservableMap;

public class Opponent {

  private String sourceType;

  private BigDecimal initialLife;

  private ArrayList<Horde> currentHorde;

  private ObservableMap<String, Creature> creaturesBaseValue;

  public Opponent(String sourceType2, ObservableMap<String, Creature> creaturesBaseValue, ArrayList<Horde> newHorde) {
    this.sourceType = sourceType;

    this.creaturesBaseValue = creaturesBaseValue;
    currentHorde = newHorde;
    initialLife = FightCalculation.sumLife(this);

  }

  public ArrayList<Horde> getCurrentHorde() {
    return currentHorde;
  }

  public ObservableMap<String, Creature> getCreaturesBaseValue() {
    return creaturesBaseValue;
  }

  public BigDecimal getInitialLife() {
    return initialLife;
  }
}
