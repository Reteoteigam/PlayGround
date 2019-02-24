package fight.views.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import utils.MyLogger;

public class LayoutBuilder {

  private static final MyLogger LOGGER = MyLogger.getLogger(LayoutBuilder.class);

  @SuppressWarnings("unchecked")

  public static <T> T createLayoutFrom(Class<?> from, String resourceName) {
    T result = null;

    ResourceBundle bundle = ResourceBundle.getBundle("i18n.LabelsBundle");
    FXMLLoader loader = new FXMLLoader(from.getResource(resourceName), bundle);
    try {
      result = (T) loader.load();
    } catch (IOException e) {
      e.printStackTrace();
      LOGGER.debug(e);
    }
    return result;
  }

}
