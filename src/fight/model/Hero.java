package fight.model;

import java.math.BigDecimal;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Hero {

  private String key;
  private ObservableList<Horde> horde = FXCollections.observableArrayList();
  private ObservableMap<String, Creature> creaturesBaseValue;

  private SimpleObjectProperty<BigDecimal> attack = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);
  private SimpleObjectProperty<BigDecimal> defense = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);
  private SimpleObjectProperty<BigDecimal> life = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);

  public String getKey() {
    return key;
  }

  public ObservableList<Horde> getHorde() {
    return this.horde;
  }

  public void setHorde(List<Horde> horde) {
    this.horde.addAll(horde);

  }

  public Hero set(ObservableMap<String, Creature> creaturesBaseValue) {
    this.creaturesBaseValue = creaturesBaseValue;
    return this;
  }

  public ObservableMap<String, Creature> getCreaturesBaseValue() {
    return creaturesBaseValue;
  }

  public BigDecimal getAttack() {
    return attack.get();
  }

  public ObservableObjectValue<BigDecimal> getAttackProperty() {
    return attack;
  }

  public Hero setAttack(BigDecimal attack) {
    this.attack.set(attack);
    return this;
  }

  public BigDecimal getDefense() {
    return defense.get();
  }

  public ObservableObjectValue<BigDecimal> getDefenseProperty() {
    return defense;
  }

  public Hero setDefense(BigDecimal defense) {
    this.defense.set(defense);
    return this;
  }

  public BigDecimal getLife() {
    return life.get();
  }

  public ObservableObjectValue<BigDecimal> getLifeProperty() {
    return life;
  }

  public Hero setLife(BigDecimal life) {
    this.life.set(life);
    return this;
  }

  public Hero setKey(String key) {
    this.key = key;
    return this;
  }

}
