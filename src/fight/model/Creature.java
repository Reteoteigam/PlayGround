package fight.model;

import java.math.BigDecimal;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Creature {

  private SimpleStringProperty name = new SimpleStringProperty();

  private SimpleObjectProperty<BigDecimal> attack = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> defense = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> life = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> velocity = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> capacity = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> point = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> herbEssences = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> crystalSplinters = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> powerStones = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> goldResin = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> mana = new SimpleObjectProperty<>();

  public Creature() {

  }

  public SimpleStringProperty getName() {
    return name;
  }

  public Creature setName(String name) {
    this.name.set(name);
    return this;
  }

  public BigDecimal getAttack() {
    return attack.getValue();
  }

  public Creature setAttack(BigDecimal attack) {
    this.attack.set(attack);
    return this;
  }

  public BigDecimal getDefense() {
    return defense.get();
  }

  public Creature setDefense(BigDecimal defense) {
    this.defense.set(defense);
    return this;
  }

  public BigDecimal getLife() {
    return life.get();
  }

  public Creature setLife(BigDecimal life) {
    this.life.set(life);
    return this;
  }

  public BigDecimal getVelocity() {
    return velocity.get();
  }

  public Creature setVelocity(BigDecimal velocity) {
    this.velocity.set(velocity);
    return this;
  }

  public BigDecimal getCapacity() {
    return capacity.get();
  }

  public Creature setCapacity(BigDecimal capacity) {
    this.capacity.set(capacity);
    return this;
  }

  public BigDecimal getPoint() {
    return point.get();
  }

  public Creature setPoint(BigDecimal point) {
    this.point.set(point);
    return this;
  }

  public BigDecimal getHerbEssences() {
    return herbEssences.get();
  }

  public Creature setHerbEssences(BigDecimal herbEssences) {
    this.herbEssences.set(herbEssences);
    return this;
  }

  public BigDecimal getCrystalSplinters() {
    return crystalSplinters.get();
  }

  public Creature setCrystalSplinters(BigDecimal crystalSplinters) {
    this.crystalSplinters.set(crystalSplinters);
    return this;
  }

  public BigDecimal getPowerStones() {
    return powerStones.get();
  }

  public Creature setPowerStones(BigDecimal powerStones) {
    this.powerStones.set(powerStones);
    return this;
  }

  public BigDecimal getGoldResin() {
    return goldResin.get();
  }

  public Creature setGoldResin(BigDecimal goldResin) {
    this.goldResin.set(goldResin);
    return this;
  }

  public BigDecimal getMana() {
    return mana.get();
  }

  public Creature setMana(BigDecimal mana) {
    this.mana.set(mana);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Creature [name=").append(name).append(", attack=").append(attack).append(", defense=")
        .append(defense).append(", life=").append(life).append(", velocity=").append(velocity).append(", capacity=")
        .append(capacity).append(", point=").append(point).append(", herbEssences=").append(herbEssences)
        .append(", crystalSplinters=").append(crystalSplinters).append(", powerStones=").append(powerStones)
        .append(", goldResin=").append(goldResin).append(", mana=").append(mana).append("]");
    return builder.toString();
  }

}
