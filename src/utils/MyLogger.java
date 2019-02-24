package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class MyLogger {
  private static final DateTimeFormatter LOG_DATEFORMAT = DateTimeFormatter
      .ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
  private static final HashMap<Class<?>, MyLogger> loggerMap = new HashMap<>();
  public static MyLogger getLogger(Class<?> targetClass) {
    MyLogger result = loggerMap.get(targetClass);
    if(result == null) {
      result = new MyLogger(targetClass);
    }
    return result;
  }
  private String className;
  private MyLogger(Class<?> targetClass) {
    className = targetClass.getSimpleName();
  }
  public void debug(Object ... messages) {
    if(messages == null) {
      return;
    }
    StringBuilder message = new StringBuilder(createCurrentTimeStamp())
        .append(" DEBUG")
        .append(" [")
        .append(className)
        .append("]: ");
    for(Object object : messages) {
      message.append(String.valueOf(object));
    }
    System.out.println(message.toString());
  }
  public static String createCurrentTimeStamp() {
    return LocalDateTime.now().format(LOG_DATEFORMAT);
  }
}