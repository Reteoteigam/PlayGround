package fight.model;

import java.math.BigDecimal;
import java.util.Map;

public class Creature {

  private String name;

  private BigDecimal attack;

  private BigDecimal defense;

  private BigDecimal life;

  private BigDecimal velocity;

  private BigDecimal capacity;

  private BigDecimal point;

  private BigDecimal herbEssences;

  private BigDecimal crystalSplinters;

  private BigDecimal powerStones;

  private BigDecimal goldResin;

  private BigDecimal mana;

  private Map<String, BigDecimal> factors;

  public String getName() {
    return name;
  }

  public Creature setName(String name) {
    this.name = name;
    return this;
  }

  public BigDecimal getAttack() {
    return attack;
  }

  public Creature setAttack(BigDecimal attack) {
    this.attack = attack;
    return this;
  }

  public BigDecimal getDefense() {
    return defense;
  }

  public Creature setDefense(BigDecimal defense) {
    this.defense = defense;
    return this;
  }

  public BigDecimal getLife() {
    return life;
  }

  public Creature setLife(BigDecimal life) {
    this.life = life;
    return this;
  }

  public BigDecimal getVelocity() {
    return velocity;
  }

  public Creature setVelocity(BigDecimal velocity) {
    this.velocity = velocity;
    return this;
  }

  public BigDecimal getCapacity() {
    return capacity;
  }

  public Creature setCapacity(BigDecimal capacity) {
    this.capacity = capacity;
    return this;
  }

  public BigDecimal getPoint() {
    return point;
  }

  public Creature setPoint(BigDecimal point) {
    this.point = point;
    return this;
  }

  public BigDecimal getHerbEssences() {
    return herbEssences;
  }

  public Creature setHerbEssences(BigDecimal herbEssences) {
    this.herbEssences = herbEssences;
    return this;
  }

  public BigDecimal getCrystalSplinters() {
    return crystalSplinters;
  }

  public Creature setCrystalSplinters(BigDecimal crystalSplinters) {
    this.crystalSplinters = crystalSplinters;
    return this;
  }

  public BigDecimal getPowerStones() {
    return powerStones;
  }

  public Creature setPowerStones(BigDecimal powerStones) {
    this.powerStones = powerStones;
    return this;
  }

  public BigDecimal getGoldResin() {
    return goldResin;
  }

  public Creature setGoldResin(BigDecimal goldResin) {
    this.goldResin = goldResin;
    return this;
  }

  public BigDecimal getMana() {
    return mana;
  }

  public Creature setMana(BigDecimal mana) {
    this.mana = mana;
    return this;
  }

  public Map<String, BigDecimal> getFactors() {
    return factors;
  }

  public Creature setFactors(Map<String, BigDecimal> factors) {
    this.factors = factors;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Creature [name=").append(name).append(", attack=").append(attack).append(", defense=")
        .append(defense).append(", life=").append(life).append(", velocity=").append(velocity).append(", capacity=")
        .append(capacity).append(", point=").append(point).append(", herbEssences=").append(herbEssences)
        .append(", crystalSplinters=").append(crystalSplinters).append(", powerStones=").append(powerStones)
        .append(", goldResin=").append(goldResin).append(", mana=").append(mana).append(", factors=").append(factors)
        .append("]");
    return builder.toString();
  }

}
