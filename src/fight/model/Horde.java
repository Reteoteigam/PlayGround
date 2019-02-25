package fight.model;

import java.math.BigDecimal;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Horde {

  private SimpleStringProperty creature = new SimpleStringProperty();

  private SimpleObjectProperty<BigDecimal> amount = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);

  public SimpleStringProperty getCreature() {
    return creature;
  }

  public Horde setName(String creature) {
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
