package fight.views;

import java.net.URL;
import java.util.ResourceBundle;

import fight.model.Creature;
import fight.model.util.DataStorage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utils.MyLogger;

public class InputAttack implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(InputAttack.class);

  @FXML
  private TableView<Creature> TBL_Attack;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

    ObservableList<Creature> values = DataStorage.getCreatureOf(DataStorage.DATAKEY_ATTACKER);
    TBL_Attack.setItems(values);

  }

}
