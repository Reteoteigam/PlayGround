package fight.model.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fight.model.Creature;
import fight.model.Hero;
import fight.model.Horde;
import utils.logger.MyLogger;

public class DataService {
  private static final utils.logger.MyLogger LOGGER = MyLogger.getLogger(DataService.class);

  public static List<Creature> loadCreatures(Path path) {
    LOGGER.debug("loadCreatures from ", path);
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      List<Creature> inputList = br.lines().map(CreatureMapper.mapToCreature).collect(Collectors.toList());
      br.close();
      return inputList;
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }
    return new ArrayList<Creature>();

  }

  public static void saveCreatures(Path path, ArrayList<Creature> creatureToWrite) {
    LOGGER.debug("saveCreatures to ", path);
    try (OutputStream aaa = Files.newOutputStream(path)) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aaa));

      creatureToWrite.stream().map(CreatureMapper.mapToLine).forEachOrdered(element -> {
        try {
          bw.write(element);
        } catch (IOException e) {
          LOGGER.debug(e);
          e.printStackTrace();
        }
      });

      bw.close();

    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }

  }

  public static List<Horde> loadHordeFrom(Path path) {
    LOGGER.debug("loadCreatures from ", path);
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      List<Horde> inputList = br.lines().map(HordeMapper.lineToHorde).collect(Collectors.toList());
      br.close();
      return inputList;
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }
    return new ArrayList<Horde>();

  }

  public static void saveHorde(Path path, ArrayList<Horde> hordeToWrite) {
    LOGGER.debug("saveCreatures to ", path);
    try (OutputStream aaa = Files.newOutputStream(path)) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aaa));

      hordeToWrite.stream().map(HordeMapper.hordeToLine).forEachOrdered(element -> {
        try {
          bw.write(element);
        } catch (IOException e) {
          LOGGER.debug(e);
          e.printStackTrace();
        }
      });

      bw.close();

    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }

  }

  public static Hero loadHeroFrom(Path path) {
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      Hero hero = HeroMapper.lineToHero(br.readLine());
      br.close();
      return hero;
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }
    return new Hero();
  }

  public static void saveHero(Path path, Hero heroToWrite) {
    LOGGER.debug("saveCreatures to ", path);
    try (OutputStream aaa = Files.newOutputStream(path)) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aaa));
      String heroToLine = HeroMapper.heroToLine(heroToWrite);
      bw.write(heroToLine);
      bw.close();
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }

  }

}
