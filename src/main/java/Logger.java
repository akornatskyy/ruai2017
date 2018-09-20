import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "HH:mm:ss.SSS [");
  private static final boolean ENABLED;

  private final String name;
  private final boolean enabled;

  static {
    ENABLED = Boolean.parseBoolean(System.getenv("LOG_ENABLED"));
    if (!ENABLED) {
      System.setOut(new PrintStream(new OutputStream() {
        @Override
        public void write(int b) {
        }
      }));
    }
  }

  public static Logger get(Class cls) {
    return get(cls, true);
  }

  public static Logger get(Class cls, boolean enabled) {
    return new Logger(cls.getName(), enabled);
  }

  private Logger(String name, boolean enabled) {
    this.name = name + "] ";
    this.enabled = ENABLED && enabled;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void log(String format, Object... args) {
    if (enabled) {
      System.out.println(
          DATE_FORMAT.format(new Date()) + name + String.format(format, args));
    }
  }
}