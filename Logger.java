public class Logger {
    

    static LogLevel CURRENT_LEVEL = LogLevel.INFO;

    public enum LogLevel {
        INFO(1),
        DEBUG(2),
        TRACE(3);

        final int value;

        LogLevel(int value) {
            this.value = value;
        }
    }
    /**
     * Ez a metódus a logolási szint állítását teszi lehetővé
     * @param logLevel - A beállított szint határozza meg a logban megjelenő logok részletességét
     */

    public static void setLogLevel(LogLevel logLevel) {
        CURRENT_LEVEL = logLevel;
    }
    public static LogLevel getLogLevel() {
        return CURRENT_LEVEL;
    }

    public static void log(LogLevel level, String message) {
        if (level.value <= CURRENT_LEVEL.value) {
            StackTraceElement[] trace = Thread.currentThread().getStackTrace();
            String currentMethodName = "Unknown";
            for (int i = 0; i < trace.length; i++) {
                if (!trace[i].getClassName().equals("java.lang.Thread")
                && !trace[i].getClassName().equals(Logger.class.getName())) {
                    currentMethodName = trace[i].getMethodName();
                    break;
                }
            }
            KeywordUtil.logInfo("[${level}] (${currentMethodName}) \t ${message}");
        }
    }
    /**
     * Általános folyamat jelzése
     * @param message - Üzenet amit látni szeretnénk
     */
    public static void info(String message) {
        log(LogLevel.INFO, message);
    }
    /**
     * Részletes adatok hibakereséshez
     * @param message - Üzenet amit látni szeretnénk
     */
    public static void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    /**
     * Legalacsonyabb szintű, részletes logolás
     * @param message - Üzenet amit látni szeretnénk
     */
    public static void trace(String message) {
        log(LogLevel.TRACE, message);
    }   
}
