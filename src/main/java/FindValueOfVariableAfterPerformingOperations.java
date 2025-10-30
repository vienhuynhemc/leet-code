
import java.util.Map;

public class FindValueOfVariableAfterPerformingOperations {

    private final Map<String, Integer> operationsMap = Map.of(
            "++X", 1,
            "X++", 1,
            "--X", -1,
            "X--", -1
    );

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            result += operationsMap.get(operation);
        }

        return result;
    }
}
