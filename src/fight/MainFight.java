package fight;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fight.model.Creature;
import fight.model.Horde;
import fight.model.util.DataService;
import fight.model.util.DataStorage;
import fight.views.RootLayout;
import javafx.collections.ObservableList;
import utils.FileService;
import utils.MyLogger;

public class MainFight {

  private static final MyLogger LOGGER = MyLogger.getLogger(MainFight.class);

  public static void main(String[] args) {

    LOGGER.debug("start");

    FileService.initialze();

    loadData();

    RootLayout.launch(RootLayout.class, args);

    saveData();

    LOGGER.debug("end");
  }

  private static void saveData() {
    Path dir = FileService.getSave();
    Path loadedCreatures = FileService.createIfNotExistsFile(dir, "creatures.csv");
    ObservableList<Creature> creatures = DataStorage.getCreatures();

    ArrayList<Creature> aaa = new ArrayList<>(creatures);
    DataService.saveCreatures(loadedCreatures, aaa);
  }

  private static void loadData() {

    Path dir = FileService.getSave();
    Path loadedCreatures = FileService.createIfNotExistsFile(dir, "creatures.csv");

    List<Creature> creatures = DataService.loadCreatures(loadedCreatures);

    if (creatures.isEmpty()) {
      LOGGER.debug("Missing last Save -> try load Backupfile for creatureData");
      try {
        Path backup = Paths.get(MainFight.class.getResource("/backup/creatures.csv").toURI());
        creatures = DataService.loadCreatures(backup);
      } catch (URISyntaxException e) {
        LOGGER.debug("Missing Backupfile for creatureData, abbort loading");
        e.printStackTrace();
        return;
      }

    }

    DataStorage.addCreatures(creatures);

    List<Horde> horde = new ArrayList<>();

    Horde creature = new Horde()
        .setAmount(BigDecimal.ONE)
        .setName(creatures.get(0).getName());
    horde.add(creature);
    DataStorage.addHordeForAttacker(horde);
  }

}
