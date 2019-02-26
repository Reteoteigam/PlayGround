package fight.views;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fight.model.Horde;
import fight.model.util.DataStorage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.converter.BigDecimalStringConverter;
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
    TBL_Attack.setEditable(true);

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

  // ################################
  // TODO auslagern
  // ##############

  class EditingCell extends TableCell<Horde, BigDecimal> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
      if (!isEmpty()) {
        super.startEdit();
        createTextField();
        setText(null);
        setGraphic(textField);
        textField.selectAll();
      }
    }

    @Override
    public void cancelEdit() {
      super.cancelEdit();

      setText(getItem().toString());
      setGraphic(null);
    }

    @Override
    public void updateItem(BigDecimal item, boolean empty) {
      super.updateItem(item, empty);

      if (empty) {
        setText(null);
        setGraphic(null);
      } else {
        if (isEditing()) {
          if (textField != null) {
            textField.setText(getString());
          }
          setText(null);
          setGraphic(textField);
        } else {
          setText(getString());
          setGraphic(null);
        }
      }
    }

    private void createTextField() {
      textField = new TextField(getString());
      textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
      textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0,
            Boolean arg1, Boolean arg2) {
          if (!arg2) {
            // TODO parseValue correct
            String newValueString = textField.getText();
            if (newValueString.matches("[0-9]+")) {
              BigDecimal newValue = new BigDecimalStringConverter().fromString(newValueString);
              commitEdit(newValue);
            }
          }
        }
      });
    }

    private String getString() {
      return getItem() == null ? "" : getItem().toString();
    }
  }

}
