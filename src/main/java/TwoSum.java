/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> map = new HashMap<>();
    final int[] result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      final int remain = target - nums[i];

      if (map.containsKey(remain)) {
        result[0] = i;
        result[1] = map.get(remain);
        break;
      }

      map.put(nums[i], i);
    }

    return result;
  }
}
