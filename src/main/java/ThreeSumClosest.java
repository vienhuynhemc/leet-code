/* vienhuynhemc */
import java.util.Arrays;

public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int minGap = Integer.MAX_VALUE;
    int result = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      final int remain = target - nums[i];

      int leftIndex = i + 1;
      int rightIndex = nums.length - 1;

      while (leftIndex < rightIndex) {
        final int sumOfTwoNums = nums[leftIndex] + nums[rightIndex];
        final int sumOfThreeNums = sumOfTwoNums + nums[i];

        if (sumOfThreeNums == target) return target;

        final int diff = Math.abs(sumOfTwoNums - remain);
        if (diff < minGap) {
          minGap = diff;
          result = sumOfThreeNums;
        }

        if (sumOfTwoNums > remain) rightIndex--;
        else leftIndex++;
      }
    }

    return result;
  }
}
