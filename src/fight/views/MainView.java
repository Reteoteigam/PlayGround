package fight.views;

import java.net.URL;
import java.util.ResourceBundle;

import fight.views.input.Input;
import fight.views.simulation.Simulation;
import fight.views.utils.LayoutBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import utils.logger.MyLogger;

public class MainView implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(MainView.class);

  @FXML
  private Tab INPUT;

  @FXML
  private Tab SIMULATION;

  public MainView() {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    LOGGER.debug("init ", location);

    Node value = LayoutBuilder.createLayoutFrom(Input.class, "Input.fxml");
    INPUT.setContent(value);

    value = LayoutBuilder.createLayoutFrom(Simulation.class, "Simulation.fxml");
    SIMULATION.setContent(value);

  }

}
