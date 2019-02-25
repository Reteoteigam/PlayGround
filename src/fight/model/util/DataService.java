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
import utils.MyLogger;

public class DataService {
  private static final MyLogger LOGGER = MyLogger.getLogger(DataService.class);

  private static final Pattern REGEX_ISANUMBER = Pattern.compile("[0-9]+");

  public static List<Creature> loadCreatures(Path path) {
    LOGGER.debug("loadCreatures from ", path);
    try (InputStream aaa = Files.newInputStream(path, StandardOpenOption.READ);) {
      BufferedReader br = new BufferedReader(new InputStreamReader(aaa));
      List<Creature> inputList = br.lines().map(mapToItem).collect(Collectors.toList());
      br.close();
      return inputList;
    } catch (FileNotFoundException e) {
      LOGGER.debug(e);
    } catch (IOException e) {
      LOGGER.debug(e);
    }
    return new ArrayList<Creature>();

  }

  private static Function<Creature, String> mapToLine = (item) -> {
    return parseItem(item);
  };

  private static Function<String, Creature> mapToItem = (line) -> {
    String[] elements = line.split("\\|");

    if (elements.length == 12) {
      return parseLine(elements);
    }
    return null;

  };

  private static Creature parseLine(String[] elements) {

    Creature result = new Creature()
        .setName(String.valueOf(elements[0]))
        .setAttack(parseToBigDecimal(elements[1]))
        .setDefense(parseToBigDecimal(elements[2]))
        .setLife(parseToBigDecimal(elements[3]))
        .setVelocity(parseToBigDecimal(elements[4]))
        .setCapacity(parseToBigDecimal(elements[5]))
        .setPoint(parseToBigDecimal(elements[6]))
        .setHerbEssences(parseToBigDecimal(elements[7]))
        .setCrystalSplinters(parseToBigDecimal(elements[8]))
        .setPowerStones(parseToBigDecimal(elements[9]))
        .setGoldResin(parseToBigDecimal(elements[10]))
        .setMana(parseToBigDecimal(elements[11]));

    return result;
  }

  private static String parseItem(Creature item) {
    StringBuffer result = new StringBuffer(12)
        .append(item.getName())
        .append("|")
        .append(item.getAttack())
        .append("|")
        .append(item.getDefense())
        .append("|")
        .append(item.getLife())
        .append("|")
        .append(item.getVelocity())
        .append("|")
        .append(item.getCapacity())
        .append("|")
        .append(item.getPoint())
        .append("|")
        .append(item.getHerbEssences())
        .append("|")
        .append(item.getCrystalSplinters())
        .append("|")
        .append(item.getPowerStones())
        .append("|")
        .append(item.getGoldResin())
        .append("|")
        .append(item.getMana())
        .append("\n");

    return result.toString();
  }

  private static BigDecimal parseToBigDecimal(String element) {
    if (element == null) {
      return BigDecimal.ZERO;
    }
    String cleanElement = element.trim();
    Matcher matcher = REGEX_ISANUMBER.matcher(cleanElement);
    if (!matcher.matches()) {
      return BigDecimal.ZERO;
    }
    return new BigDecimal(cleanElement);

  }

  public static void saveCreatures(Path path, ArrayList<Creature> creatures) {
    LOGGER.debug("saveCreatures to ", path);
    try (OutputStream aaa = Files.newOutputStream(path)) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aaa));

      creatures.stream().map(mapToLine).forEachOrdered(element -> {
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

}
