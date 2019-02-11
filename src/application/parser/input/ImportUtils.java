package application.parser.input;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class ImportUtils {

	private static ImportUtils instance;
	private static LinkedBlockingQueue<String> values;

	private ImportUtils() {
		Thread
		values = new LinkedBlockingQueue<>(3);
	}

	public static ImportUtils getInstance() {
		if (instance == null) {
			instance = new ImportUtils();
		}
		return instance;
	}

	public static void parseRawData(String text) {
		values.offer(text);
	}

	
	
	
}
