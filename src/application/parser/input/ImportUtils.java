package application.parser.input;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImportUtils {

	private static final Log LOGGER = LogFactory.getLog(ImportUtils.class);

	private static LinkedBlockingQueue<String> values = new LinkedBlockingQueue<String>(3);

	public static void parseRawData(String text) {
		values.offer(text);
		LOGGER.debug(text);
	}

}
