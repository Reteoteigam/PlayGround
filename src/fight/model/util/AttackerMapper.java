package fight.model.util;

import java.util.function.Function;

import fight.model.Horde;

public class AttackerMapper {

  public static Function<Horde, String> mapToLine = (item) -> {
    return parseItem(item);
  };

  public static Function<String, Horde> mapToItem = (line) -> {
    String[] elements = line.split("\\|");

    if (elements.length == 2) {
      return parseLine(elements);
    }
    return null;

  };

  private static String parseItem(Horde item) {
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
