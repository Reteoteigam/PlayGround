package application.parser.input;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ImportUtils {

	Logger logger = Logger.getLogger(ImportUtils.class.getName());

	private static LinkedBlockingQueue<String> values = new LinkedBlockingQueue<String>(3);

	public static void parseRawData(String text) {
		values.offer(text);
		System.out.println(text);
	}

}
