
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] twoSum = new int[2];

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                twoSum[0] = i;
                twoSum[1] = map.get(remain);
            } else {
                map.put(nums[i], i);
            }
        }

        return twoSum;
    }

}
