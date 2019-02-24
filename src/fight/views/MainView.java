package fight.views;

import java.net.URL;
import java.util.ResourceBundle;

import fight.views.utils.LayoutBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import utils.MyLogger;

public class MainView implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(MainView.class);

  @FXML
  private BorderPane INPUT_ATTACKER;
  @FXML
  private BorderPane INPUT_DEFENDER;

  public MainView() {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    LOGGER.debug("init ", location);

    AnchorPane leftSide = LayoutBuilder.createLayoutFrom(InputAttack.class, "InputAttack.fxml");
    AnchorPane rightSide = LayoutBuilder.createLayoutFrom(InputAttack.class, "InputDefend.fxml");

    INPUT_ATTACKER.setCenter(leftSide);
    INPUT_DEFENDER.setCenter(rightSide);

  }

}
