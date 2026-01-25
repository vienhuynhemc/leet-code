/* vienhuynhemc */
import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

  public int minimumDifference(int[] nums, int k) {
    if (k == 1) return 0;

    Arrays.sort(nums);

    int result = Integer.MAX_VALUE;

    for (int i = k - 1; i < nums.length; i++) {
      final int difference = nums[i] - nums[i - k + 1];
      result = Math.min(result, difference);
    }

    return result;
  }
}
