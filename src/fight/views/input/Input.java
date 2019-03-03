package fight.views.input;

import java.net.URL;
import java.util.ResourceBundle;

import fight.views.utils.LayoutBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import utils.logger.MyLogger;

public class Input implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(Input.class);
  @FXML
  private BorderPane INPUT_ATTACKER;
  @FXML
  private BorderPane INPUT_DEFENDER;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    LOGGER.debug("init ", location);

    AnchorPane leftSide = LayoutBuilder.createLayoutFrom(Attack.class, "InputAttack.fxml");
    AnchorPane rightSide = LayoutBuilder.createLayoutFrom(Defend.class, "InputDefend.fxml");

    INPUT_ATTACKER.setCenter(leftSide);
    INPUT_DEFENDER.setCenter(rightSide);

  }
}
