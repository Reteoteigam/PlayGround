package fight.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utils.MyLogger;

public class InputDefend implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(InputDefend.class);

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

  }

}
