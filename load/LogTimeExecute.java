package load;

import java.util.function.Function;

public class LogTimeExecute {

    private static LogTimeExecute logTimeExecute;

    public static LogTimeExecute getInstance() {
        if (logTimeExecute == null) {
            logTimeExecute = new LogTimeExecute();
        }
        return logTimeExecute;
    }

    public <T> void log(Function<Void, T> function) {
        long startTime = System.currentTimeMillis();
        T t = function.apply(null);
        System.out.println("Execute time: " + (System.currentTimeMillis() - startTime));
        System.out.println("Result: " + t);
    }

}
