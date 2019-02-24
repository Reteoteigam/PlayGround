package fight;

import fight.model.util.DataService;
import fight.views.RootLayout;
import utils.MyLogger;

public class MainFight {

  private static final MyLogger LOGGER = MyLogger.getLogger(MainFight.class);

  public static void main(String[] args) {

    LOGGER.debug("start");

    DataService.loadCreatures(MainFight.class, "/data/creatures.csv");

//    DataStorage.addCreatureFor(name, creature);

    RootLayout.launch(RootLayout.class, args);
    LOGGER.debug("end");
  }

}
