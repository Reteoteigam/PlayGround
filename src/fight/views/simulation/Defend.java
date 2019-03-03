package fight.views.simulation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fight.model.Horde;
import fight.model.Hero;
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

public class Defend implements Initializable {
  private static final MyLogger LOGGER = MyLogger.getLogger(Defend.class);

  @FXML
  private TableView<Horde> TBL_DEFEND;

  @FXML
  private TableColumn<Horde, String> COL_CREATURE;
  @FXML
  private TableColumn<Horde, BigDecimal> COL_AMOUNT;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    LOGGER.debug("init ", location);

    Hero player = Context.getPlayer(Context.DATAKEY_DEFENDER);

    TBL_DEFEND.setItems(player.getHorde());
    TBL_DEFEND.setEditable(true);

    COL_CREATURE.setCellValueFactory(cellData -> cellData.getValue().getCreatureProperty());

    COL_AMOUNT.setCellValueFactory(new PropertyValueFactory<Horde, BigDecimal>("amount"));

    COL_AMOUNT.setCellFactory(cellFactory);
    COL_AMOUNT.setOnEditCommit(
        new EventHandler<CellEditEvent<Horde, BigDecimal>>() {
          @Override
          public void handle(CellEditEvent<Horde, BigDecimal> t) {
            ((Horde) t.getTableView().getItems().get(
                t.getTablePosition().getRow())).setAmount(t.getNewValue());

            System.out.println("t: " + t.getOldValue() + " new " + t.getNewValue());
          }
        });

  }

  Callback<TableColumn<Horde, BigDecimal>, TableCell<Horde, BigDecimal>> cellFactory = new Callback<TableColumn<Horde, BigDecimal>, TableCell<Horde, BigDecimal>>() {
    public TableCell<Horde, BigDecimal> call(TableColumn<Horde, BigDecimal> p) {
      return new EditingCell();
    }
  };

}
