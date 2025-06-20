public class Logger {
    private static volatile Logger singleInstance;
    private Logger() {}

    public static Logger getInstance() {
        if (singleInstance == null) {
            synchronized (Logger.class) {
                if (singleInstance == null) {
                    singleInstance = new Logger();
                }
            }
        }
        return singleInstance;
    }

    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}