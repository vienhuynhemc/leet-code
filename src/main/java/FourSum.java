/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4) return new ArrayList<>();

    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        final long remain = (long) target - nums[i] - nums[j];

        int leftIndex = j + 1;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
          long sumOfTwoNums = nums[leftIndex] + nums[rightIndex];

          if (sumOfTwoNums == remain) {
            final List<Integer> fourSum = new ArrayList<>();
            fourSum.add(nums[i]);
            fourSum.add(nums[j]);
            fourSum.add(nums[leftIndex]);
            fourSum.add(nums[rightIndex]);

            result.add(fourSum);

            final int thirdNum = nums[leftIndex++];
            while (leftIndex < rightIndex && nums[leftIndex] == thirdNum) leftIndex++;
          } else if (sumOfTwoNums > remain) rightIndex--;
          else leftIndex++;
        }
      }
    }

    return result;
  }

  static void main() {
    FourSum handler = new FourSum();
    System.out.println(handler.fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
  }
}
