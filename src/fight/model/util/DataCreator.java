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
import fight.model.Hero;
import javafx.collections.ObservableList;
import utils.logger.MyLogger;

public class DataCreator {
  private static final String FILE_TYPE = ".csv";
  private static final MyLogger LOGGER = MyLogger.getLogger(DataCreator.class);

  public static void loadData() {
    // base dir to save things
    Path fromDir = FileService.getSave();

// initialData For Attacker

    Hero hero = loadPlayer(Context.DATAKEY_ATTACKER, fromDir);
    Context.addPlayer(hero);

    hero = loadPlayer(Context.DATAKEY_DEFENDER, fromDir);
    Context.addPlayer(hero);
  }

  private static void loadCreaturesFrom(String dataKey, Path fromDir) {

    String saveFileName = dataKey + ".creatureValues" + FILE_TYPE;

    Path creaturesSource = FileService.createIfNotExistsFile(fromDir, saveFileName);
    List<Creature> creatures = DataService.loadCreatures(creaturesSource);
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

  private static Hero loadPlayer(String dataKey, Path fromDir) {
    // try saved files

    Hero hero = loadHero(dataKey, fromDir);
    List<Horde> horde = loadHorde(dataKey, fromDir);
    hero.setHorde(horde);
    loadCreaturesFrom(dataKey, fromDir);
    return hero;
  }

  private static Hero loadHero(String dataKey, Path fromDir) {
    String saveFileName = dataKey + ".heroValues" + FILE_TYPE;
    Path heroSource = FileService.createIfNotExistsFile(fromDir, saveFileName);
    Hero hero = DataService.loadHeroFrom(heroSource);

    if (!dataKey.equals(hero.getKey())) {
      try {
        Path backup = Paths.get(MainFight.class.getResource("/backup/hero.csv").toURI());
        hero = DataService.loadHeroFrom(backup);
        hero.setKey(dataKey);
      } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return hero;
  }

  private static List<Horde> loadHorde(String dataKey, Path fromDir) {
    String saveFileName = dataKey + ".horde" + FILE_TYPE;
    Path hordeSource = FileService.createIfNotExistsFile(fromDir, saveFileName);
    List<Horde> horde = DataService.loadHordeFrom(hordeSource);

    // take backupversion
    if (horde.isEmpty()) {
      try {
        Path backup = Paths.get(MainFight.class.getResource("/backup/horde.csv").toURI());
        horde = DataService.loadHordeFrom(backup);

      } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    return horde;

  }

  public static void saveData() {
    // base dir to save things
    Path toDir = FileService.getSave();

    saveCreatures(toDir);

    for (Hero player : Context.getPlayers()) {
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

  private static void saveHordeFor(Hero player, Path toDir) {
    String saveFileName = player.getKey() + ".horde" + FILE_TYPE;
    Path saveFile = FileService.createIfNotExistsFile(toDir, saveFileName);
    ArrayList<Horde> horde = new ArrayList<Horde>(player.getHorde());
    DataService.saveHorde(saveFile, horde);
  }
}
