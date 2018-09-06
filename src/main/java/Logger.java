import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "HH:mm:ss.SSS [");

  private final String name;

  public static Logger get(Class cls) {
    return new Logger(cls.getName());
  }

  private Logger(String name) {
    this.name = name + "] ";
  }

  public void log(String format, Object... args) {
    System.out.println(
        DATE_FORMAT.format(new Date()) + name + String.format(format, args));
  }
}