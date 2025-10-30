
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindLuckyIntegerInAnArray {

    public int findLucky(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (final int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Objects.equals(entry.getKey(), entry.getValue()) && entry.getKey() > result) {
                result = entry.getKey();
            }
        }

        return result;
    }

}
