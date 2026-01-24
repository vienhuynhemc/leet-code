/* vienhuynhemc */
import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);

    int minPairSum = 0;
    int browseLength = nums.length / 2;
    for (int i = 0; i < browseLength; i++) {
      final int pairSum = nums[i] + nums[nums.length - 1 - i];
      if (pairSum > minPairSum) {
        minPairSum = pairSum;
      }
    }

    return minPairSum;
  }
}
