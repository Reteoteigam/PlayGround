package fight.views.simulation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import fight.calculation.FightCalculation;
import fight.calculation.SimulationContextCreator;
import fight.model.Creature;
import fight.model.Horde;
import fight.model.Hero;
import fight.model.SimulationContext;
import fight.model.util.Context;
import fight.model.util.SecureNumberParser;
import fight.views.utils.LayoutBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import utils.logger.MyLogger;

public class Simulation implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(Simulation.class);

  @FXML
  private BorderPane OUTPUT_ATTACKER;
  @FXML
  private BorderPane OUTPUT_DEFENDER;

  public Simulation() {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    LOGGER.debug("init ", location);

    AnchorPane leftSide = LayoutBuilder.createLayoutFrom(Attack.class, "Attack.fxml");
    AnchorPane rightSide = LayoutBuilder.createLayoutFrom(Defend.class, "Defend.fxml");

    OUTPUT_ATTACKER.setCenter(leftSide);
    OUTPUT_DEFENDER.setCenter(rightSide);

  }

  @FXML
  private void startSimulation() {

    SimulationContext simulationContext = SimulationContextCreator.create();

    simulationContext = FightCalculation.oneStep(simulationContext);

    System.out.println(simulationContext);
//  Object simulation;
//  simulationContext = simulation.oneStepSimulation(simulationContext);
  }

}
