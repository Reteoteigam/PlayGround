package fight.model.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import utils.MyLogger;

public class DataService {
  private static final MyLogger LOGGER = MyLogger.getLogger(DataService.class);

  public static void loadCreatures(Class<?> aclass, String string) {
    LOGGER.debug("loadCreatures from ", aclass, " with ", string);
    try (InputStream source = aclass.getResourceAsStream(string)) {

      Scanner scanner = new Scanner(source);
      scanner.useDelimiter("|");
      while (scanner.hasNext()) {
        System.out.print(scanner.next() );
      }
      scanner.close();

    } catch (IOException e) {
      LOGGER.debug(e);
      e.printStackTrace();
    }
  }

}
