package fight.views.simulation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fight.model.Horde;
import fight.model.Hero;
import fight.model.SimulationContext;
import fight.model.util.Context;
import fight.views.EditingCell;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import utils.logger.MyLogger;

public class Attack implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(Attack.class);

  @FXML
  private TableView<SimulationContext> TBL_ATTACK;

  @FXML
  private TableColumn<SimulationContext, String> COL_CREATURE;
  @FXML
  private TableColumn<SimulationContext, BigDecimal> COL_AMOUNT;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

    SimulationContext simulationContext = Context.getSimulationContext();

    
    
    
    
//    TBL_ATTACK.setItems(simulationContext.getAttacker());
    

//    COL_CREATURE.setCellValueFactory(cellData -> cellData.getValue().getCreatureProperty());
//    COL_AMOUNT.setCellValueFactory(new PropertyValueFactory<Horde, BigDecimal>("amount"));
    
    
    
    
    

  }

}
