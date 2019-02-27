package fight.model.util;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fight.MainFight;
import fight.model.Creature;
import fight.model.Horde;
import fight.model.Player;
import javafx.collections.ObservableList;
import utils.logger.MyLogger;

public class DataCreator {
  private static final MyLogger LOGGER = MyLogger.getLogger(DataCreator.class);

  public static void loadData() {
    // base dir to save things
    Path fromDir = FileService.getSave();
    // initial creatures
    loadCreaturesFrom(fromDir);
// initialData For Attacker

    loadHordeFor(new Player(Context.DATAKEY_ATTACKER), fromDir);
    loadHordeFor(new Player(Context.DATAKEY_DEFENDER), fromDir);
  }

  private static void loadCreaturesFrom(Path dir) {

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
    Context.addCreatures(creatures);
  }

  private static void loadHordeFor(Player player, Path fromDir) {
    // try saved files
    String saveFileName = player.getSaveFileName();
    Path loadedAttacker = FileService.createIfNotExistsFile(fromDir, saveFileName);
    List<Horde> horde = DataService.loadAttacker(loadedAttacker);

    // take backupversion
    if (horde.isEmpty()) {
      horde = new ArrayList<>();
      List<Creature> creatures = Context.getCreatures();
      for (Creature creature : creatures) {
        Horde currentCreature = new Horde()
            .setAmount(BigDecimal.ZERO)
            .setCreature(creature.getName());
        horde.add(currentCreature);
      }
    }

    player.add(horde);
    Context.addPlayer(player);

  }

  public static void saveData() {
    // base dir to save things
    Path toDir = FileService.getSave();

    saveCreatures(toDir);

    for (Player player : Context.getPlayers()) {
      saveHordeFor(player, toDir);
    }

  }

  private static void saveCreatures(Path toDir) {
    // save default initial data
    Path loadedCreatures = FileService.createIfNotExistsFile(toDir, "creatures.csv");
    ObservableList<Creature> creatures = Context.getCreatures();
    ArrayList<Creature> creatureToWrite = new ArrayList<>(creatures);
    DataService.saveCreatures(loadedCreatures, creatureToWrite);

  }

  private static void saveHordeFor(Player player, Path toDir) {
    String saveFileName = player.getSaveFileName();
    Path saveFile = FileService.createIfNotExistsFile(toDir, saveFileName);
    ArrayList<Horde> horde = new ArrayList<Horde>(player.getHorde());
    DataService.saveAttacker(saveFile, horde);
  }
}
