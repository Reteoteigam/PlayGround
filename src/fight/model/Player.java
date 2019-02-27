package fight.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {

  private String type;
  private ObservableList<Horde> horde = FXCollections.observableArrayList();

  public Player(String type) {

    this.type = type;

  }

  public String getType() {
    return type;
  }

  public String getSaveFileName() {

    return type + ".csv";

  }

  public ObservableList<Horde> getHorde() {
    return this.horde;
  }

  public void add(List<Horde> horde) {
    this.horde.addAll(horde);

  }

}
