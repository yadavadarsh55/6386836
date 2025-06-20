public class Test {
    public static void main(String[] args) {
        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();

        if (loggerA == loggerB) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Multiple Logger instances exist.");
        }
        loggerA.log("First log message.");
        loggerB.log("Second log message.");
    }
}