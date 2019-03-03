package fight.model.util;

import java.util.function.Function;

import fight.model.Horde;

public class HordeMapper {

  public static Function<Horde, String> hordeToLine = (item) -> {
    return parseHorde(item);
  };

  public static Function<String, Horde> lineToHorde = (line) -> {
    String[] elements = line.split("\\|");

    if (elements.length == 2) {
      return parseLine(elements);
    }
    return null;

  };

 

  private static String parseHorde(Horde item) {
    StringBuffer result = new StringBuffer(2)
        .append(item.getCreature())
        .append("|")
        .append(item.getAmount())
        .append("\n");

    return result.toString();

  }

  private static Horde parseLine(String[] elements) {

    Horde result = new Horde()
        .setAmount(SecureNumberParser.parseToBigDecimal(elements[1]))
        .setCreature(elements[0]);

    return result;
  }

}
