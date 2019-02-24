package fight;

import fight.views.RootLayout;
import utils.MyLogger;

public class MainFight {

  private static final MyLogger LOGGER = MyLogger.getLogger(MainFight.class);

  public static void main(String[] args) {

    LOGGER.debug("start");
    RootLayout.launch(RootLayout.class, args);
    LOGGER.debug("end");
  }

}
