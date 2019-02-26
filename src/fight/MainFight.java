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
    // base dir to save things
    Path dir = FileService.getSave();

    // save default initial data
    Path loadedCreatures = FileService.createIfNotExistsFile(dir, "creatures.csv");
    ObservableList<Creature> creatures = DataStorage.getCreatures();
    ArrayList<Creature> creatureToWrite = new ArrayList<>(creatures);
    DataService.saveCreatures(loadedCreatures, creatureToWrite);

    // save current attacker
    Path loadedAttacker = FileService.createIfNotExistsFile(dir, "attacker.csv");
    ObservableList<Horde> attacker = DataStorage.getHordeOf(DataStorage.DATAKEY_ATTACKER);
    ArrayList<Horde> attackerToWrite = new ArrayList<>(attacker);
    DataService.saveAttacker(loadedAttacker, attackerToWrite);

  }

  private static void loadData() {
// base dir to save things
    Path dir = FileService.getSave();

    // initialData for Creature calculation
    // try saved files
    Path loadedCreatures = FileService.createIfNotExistsFile(dir, "creatures.csv");
    List<Creature> creatures = DataService.loadCreatures(loadedCreatures);
    // take backupversion
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

// initialData For Attacker    
    // try saved files
    Path loadedAttacker = FileService.createIfNotExistsFile(dir, "attacker.csv");
    List<Horde> hordeOfAttacker = DataService.loadAttacker(loadedAttacker);

    // take backupversion
    if (hordeOfAttacker.isEmpty()) {
      hordeOfAttacker = new ArrayList<>();
      for (Creature creature : creatures) {
        Horde currentCreature = new Horde()
            .setAmount(BigDecimal.ZERO)
            .setCreature(creature.getName());
        hordeOfAttacker.add(currentCreature);
      }
    }

    DataStorage.addHordeForAttacker(hordeOfAttacker);
  }

}
