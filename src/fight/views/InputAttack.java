package fight.views;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fight.model.Creature;
import fight.model.Horde;
import fight.model.util.DataStorage;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utils.MyLogger;

public class InputAttack implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(InputAttack.class);

  @FXML
  private TableView<Horde> TBL_Attack;

  @FXML
  private TableColumn<Horde, String> COL_CREATURE;
  @FXML
  private TableColumn<Horde, BigDecimal> COL_AMOUNT;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

    ObservableList<Horde> horde = DataStorage.getHordeOf(DataStorage.DATAKEY_ATTACKER);
    TBL_Attack.setItems(horde);

    COL_CREATURE.setCellValueFactory(cellData -> cellData.getValue().getCreature());
    COL_AMOUNT.setCellValueFactory(cellData -> cellData.getValue().getAmount());

  }

}
