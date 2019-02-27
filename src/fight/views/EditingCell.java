package fight.views;

import java.math.BigDecimal;

import fight.model.Horde;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.util.converter.BigDecimalStringConverter;

public class EditingCell extends TableCell<Horde, BigDecimal> {

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