package fight.model.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import fight.model.Creature;

public class CreatureMapper {

  public static Function<Creature, String> mapToLine = (item) -> {
    return parseItem(item);
  };

  public static Function<String, Creature> mapToCreature = (line) -> {
    String[] elements = line.split("\\|");

    if (elements.length >= 12) {
      return parseLine(elements);
    }
    return null;

  };

  private static Creature parseLine(String[] elements) {

    Creature result = new Creature()
        .setName(String.valueOf(elements[0]))
        .setAttack(SecureNumberParser.parseToBigDecimal(elements[1]))
        .setDefense(SecureNumberParser.parseToBigDecimal(elements[2]))
        .setLife(SecureNumberParser.parseToBigDecimal(elements[3]))
        .setVelocity(SecureNumberParser.parseToBigDecimal(elements[4]))
        .setCapacity(SecureNumberParser.parseToBigDecimal(elements[5]))
        .setPoint(SecureNumberParser.parseToBigDecimal(elements[6]))
        .setHerbEssences(SecureNumberParser.parseToBigDecimal(elements[7]))
        .setCrystalSplinters(SecureNumberParser.parseToBigDecimal(elements[8]))
        .setPowerStones(SecureNumberParser.parseToBigDecimal(elements[9]))
        .setGoldResin(SecureNumberParser.parseToBigDecimal(elements[10]))
        .setMana(SecureNumberParser.parseToBigDecimal(elements[11]))
        .setFactors(parseLineFactors(elements));
    return result;
  }

  private static Map<String, BigDecimal> parseLineFactors(String[] elements) {
    Map<String, BigDecimal> factors = new HashMap<>();
    for (int i = 12; ((i + 1) < elements.length); i++) {

      String key = elements[i];
      i++;
      BigDecimal value = SecureNumberParser.parseToBigDecimal(elements[i]);
      factors.put(key, value);
    }
    return factors;
  }

  private static String parseItem(Creature item) {
    StringBuffer result = new StringBuffer()
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
        .append(parseFactors(item.getFactors()))
        .append("\n");

    return result.toString();
  }

  private static String parseFactors(Map<String, BigDecimal> factors) {
    Set<Entry<String, BigDecimal>> entrySet = factors.entrySet();
    StringBuffer result = new StringBuffer();
    for (Entry<String, BigDecimal> entry : entrySet) {
      result.append("|");
      result.append(entry.getKey());
      result.append("|");
      result.append(entry.getValue().toPlainString());
    }
    return result.toString();
  }

}
