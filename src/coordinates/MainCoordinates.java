package coordinates;

import coordinates.views.RootLayout;
import utils.logger.MyLogger;

public class MainCoordinates {

  private static final MyLogger LOGGER = MyLogger.getLogger(MainCoordinates.class);

  public static void main(String[] args) {

    LOGGER.debug("start");
    RootLayout.launch(RootLayout.class, args);
    LOGGER.debug("end");
  }

}
