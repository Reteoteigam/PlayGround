package fight.model.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import fight.model.Creature;
import fight.model.Horde;
import utils.MyLogger;

public class DataService {
  private static final MyLogger LOGGER = MyLogger.getLogger(DataService.class);

  public static List<Creature> loadCreatures(Path path) {
    LOGGER.debug("loadCreatures from ", path);
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      List<Creature> inputList = br.lines().map(CreatureMapper.mapToItem).collect(Collectors.toList());
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
          // TODO Auto-generated catch block
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

  public static void saveAttacker(Path path, ArrayList<Horde> attackerToWrite) {
    LOGGER.debug("saveCreatures to ", path);
    try (OutputStream aaa = Files.newOutputStream(path)) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aaa));

      attackerToWrite.stream().map(AttackerMapper.mapToLine).forEachOrdered(element -> {
        try {
          bw.write(element);
        } catch (IOException e) {
          // TODO Auto-generated catch block
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

  public static List<Horde> loadAttacker(Path path) {
    LOGGER.debug("loadCreatures from ", path);
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      List<Horde> inputList = br.lines().map(AttackerMapper.mapToItem).collect(Collectors.toList());
      br.close();
      return inputList;
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }
    return new ArrayList<Horde>();

  }

}
