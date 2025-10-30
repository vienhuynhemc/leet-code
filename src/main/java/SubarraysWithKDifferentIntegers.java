/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

  public int subarraysWithKDistinct(int[] nums, int k) {
    return calculate(nums, k) - calculate(nums, k - 1);
  }

  private int calculate(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();

    int n = nums.length;

    int left = 0;
    int right = 0;
    int totalCount = 0;

    while (right < n) {
      freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

      while (freqMap.size() > k) {
        freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
        if (freqMap.get(nums[left]) == 0) {
          freqMap.remove(nums[left]);
        }
        left++;
      }

      totalCount += (right - left + 1);

      right++;
    }
    return totalCount;
  }
}
