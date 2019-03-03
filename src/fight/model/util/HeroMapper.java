package fight.model.util;

import fight.model.Hero;

public class HeroMapper {

  public static String heroToLine(Hero hero) {
    StringBuffer result = new StringBuffer(2)
        .append(hero.getKey())
        .append("|")
        .append(hero.getAttack())
        .append("|")
        .append(hero.getDefense())
        .append("|")
        .append(hero.getLife())
        .append("\n");
    return result.toString();
  }

  public static Hero lineToHero(String line) {
    if (line == null) {
      return new Hero();
    }
    String[] elements = line.split("\\|");
    if (elements.length != 4) {
      return new Hero();
    }
    return parseLine(elements);

  }

  private static Hero parseLine(String[] elements) {

    Hero result = new Hero()
        .setKey(elements[0])
        .setAttack(SecureNumberParser.parseToBigDecimal(elements[1]))
        .setDefense(SecureNumberParser.parseToBigDecimal(elements[2]))
        .setLife(SecureNumberParser.parseToBigDecimal(elements[3]));

    return result;
  }

}
