/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    final List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      final int remain = -nums[i];

      int leftIndex = i + 1;
      int rightIndex = nums.length - 1;

      while (leftIndex < rightIndex) {
        final int sumOfTwoNums = nums[leftIndex] + nums[rightIndex];

        if (sumOfTwoNums == remain) {
          final List<Integer> threeSum = new ArrayList<>();
          threeSum.add(nums[i]);
          threeSum.add(nums[leftIndex]);
          threeSum.add(nums[rightIndex]);

          result.add(threeSum);

          int secondNum = nums[leftIndex++];
          while (leftIndex < rightIndex && nums[leftIndex] == secondNum) leftIndex++;
        } else if (sumOfTwoNums > remain) rightIndex--;
        else leftIndex++;
      }
    }

    return result;
  }

  static void main() {
    ThreeSum threeSum = new ThreeSum();
    System.out.println(threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    System.out.println(threeSum.threeSum(new int[] { 0, 1, 1 }));
    System.out.println(threeSum.threeSum(new int[] { 0, 0, 0 }));
  }
}
