package fight.model.util;

import java.util.function.Function;

import fight.model.Creature;

public class CreatureMapper {

  public static Function<Creature, String> mapToLine = (item) -> {
    return parseItem(item);
  };

  public static Function<String, Creature> mapToItem = (line) -> {
    String[] elements = line.split("\\|");

    if (elements.length == 12) {
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
        .setMana(SecureNumberParser.parseToBigDecimal(elements[11]));

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

}
