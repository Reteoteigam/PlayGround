package fight.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import utils.MyLogger;

public class InputAttack implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(InputAttack.class);

  @FXML
  TableColumn<String, String> abx;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

//    abx.getCe

  }

}
