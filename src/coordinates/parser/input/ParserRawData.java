package coordinates.parser.input;

import utils.logger.MyLogger;

public class ParserRawData implements Runnable {

  private static final MyLogger LOGGER = MyLogger.getLogger(ParserRawData.class);
  private ImportUtils importUtils;


  public ParserRawData(ImportUtils importUtils) {
    this.importUtils = importUtils;
  }

  @Override
  public void run() {

    while (runCondition()) {
      String nextValue = importUtils.getNextValue();
      LOGGER.debug(nextValue);
    }

  }

  private boolean runCondition() {
    return importUtils.isRunning();

  }

}
