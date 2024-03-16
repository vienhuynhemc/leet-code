import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countAndIndex = new HashMap<>();
        int maxLength = 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (count == 0) {
                maxLength = i + 1;
                continue;
            }

            if (countAndIndex.containsKey(count)) {
                int length = i - countAndIndex.get(count);
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                countAndIndex.put(count, i);
            }
        }

        return maxLength;
    }

}
