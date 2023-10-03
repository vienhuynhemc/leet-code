import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> data = new HashMap<>();

        for (int num : nums) {
            if (!data.containsKey(num)) {
                data.put(num, 1);
                continue;
            }

            int count = data.get(num);
            result += count;
            data.put(num, count + 1);
        }

        return result;
    }

}
