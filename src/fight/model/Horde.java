package fight.model;

import java.math.BigDecimal;

import javafx.beans.property.SimpleObjectProperty;

public class Horde {

  private SimpleObjectProperty<Creature> creature = new SimpleObjectProperty<>();

  private SimpleObjectProperty<BigDecimal> amount = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);

  public Creature getCreature() {
    return creature.get();
  }

  public Horde setName(Creature creature) {
    this.creature.set(creature);
    return this;
  }

  public SimpleObjectProperty<BigDecimal> getAmount() {
    return amount;
  }

  public Horde setAmount(BigDecimal amount) {
    this.amount.set(amount);
    return this;
  }

}
