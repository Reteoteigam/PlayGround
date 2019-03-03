package fight.model;

import java.math.BigDecimal;

import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Horde {

  private SimpleStringProperty creature = new SimpleStringProperty();

  private SimpleObjectProperty<BigDecimal> amount = new SimpleObjectProperty<BigDecimal>(BigDecimal.ZERO);

  public Horde setCreature(String creature) {
    this.creature.set(creature);
    return this;
  }

  public SimpleStringProperty getCreatureProperty() {
    return creature;
  }

  public String getCreature() {
    return creature.get();
  }

  public Horde setAmount(BigDecimal amount) {
    this.amount.set(amount);
    return this;
  }

  public SimpleObjectProperty<BigDecimal> getAmountProperty() {
    return amount;
  }

  public BigDecimal getAmount() {
    return amount.get();
  }

}
