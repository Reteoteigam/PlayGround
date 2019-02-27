package coordinates.parser.input;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import utils.logger.MyLogger;

public class ImportUtils {

  private static final double _1000D = 10d;

  private static final MyLogger LOGGER = MyLogger.getLogger(ImportUtils.class);

  private static LinkedBlockingQueue<String> values;

  private static ImportUtils INSTANCE = new ImportUtils();

  private ImportUtils() {

    if (INSTANCE == null) {
      values = new LinkedBlockingQueue<String>(3);

      ExecutorService blubber = Executors.newCachedThreadPool();
      blubber.execute(new ParserRawData(this));
      blubber.shutdown();
    }

  }

  public static void offerRawData(String text) {

    try {
      boolean offered = values.offer(text, calculateRandomTime(), TimeUnit.SECONDS);
      LOGGER.debug("offered:", offered, "Values are now:", values);
    } catch (InterruptedException e) {
      LOGGER.debug("interupt in offering ", text);
    }

  }

  public boolean isRunning() {
    return true;
  }

  public String getNextValue() {

    try {
      String polledValue = values.poll(calculateRandomTime(), TimeUnit.SECONDS);
      return polledValue;
    } catch (InterruptedException e) {
      LOGGER.debug("Interupted in polling");
    }
    return "";
  }

  private static long calculateRandomTime() {
    return Double.valueOf(_1000D * Math.random()).longValue();
  }
}
