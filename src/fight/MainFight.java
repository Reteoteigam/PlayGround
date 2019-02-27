package fight;

import fight.model.util.DataCreator;
import fight.model.util.FileService;
import fight.views.RootLayout;
import utils.logger.MyLogger;

public class MainFight {

  private static final MyLogger LOGGER = MyLogger.getLogger(MainFight.class);

  public static void main(String[] args) {

    LOGGER.debug("start");

    FileService.initialze();

    DataCreator.loadData();

    RootLayout.launch(RootLayout.class, args);

    DataCreator.saveData();

    LOGGER.debug("end");
  }

}
