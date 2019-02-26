package fight.model.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecureNumberParser {

  private static final Pattern REGEX_ISANUMBER = Pattern.compile("[0-9]+");

  public static BigDecimal parseToBigDecimal(String string) {
    if (string == null) {
      return BigDecimal.ZERO;
    }
    String cleanElement = string.trim();
    Matcher matcher = REGEX_ISANUMBER.matcher(cleanElement);
    if (!matcher.matches()) {
      return BigDecimal.ZERO;
    }
    return new BigDecimal(cleanElement);

  }

}
