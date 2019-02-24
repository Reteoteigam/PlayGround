package coordinates.views;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import coordinates.parser.input.ImportUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ImportView implements Initializable {
  private static final Log LOGGER = LogFactory.getLog(ImportView.class);
  @FXML
  private Button IMPORT_BTN_IMPORT;

  @FXML
  private TextArea IMPORT_INPUTFIELD;

  @FXML
  private TableView<?> Table_ID;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
//    ObservableList<Player> items= new ;
//    TableView table = new TableView<S>(items);
//
//    table.setEditable(true);
//
//    TableColumn firstNameCol = new TableColumn("First Name");
//    TableColumn lastNameCol = new TableColumn("Last Name");
//    TableColumn emailCol = new TableColumn("Email");
//
//    table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
  }

  public void importData(ActionEvent event) {
    LOGGER.debug(event);
    String text = IMPORT_INPUTFIELD.getText();

    ImportUtils.offerRawData(text);

  }

}