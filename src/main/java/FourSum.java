/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4) {
      return new ArrayList<>();
    }

    List<List<Integer>> quadruplets = new ArrayList<>();
    int length = nums.length;
    int endIdxNumOne = length - 3;
    int endIdxNumTwo = length - 2;

    Arrays.sort(nums);

    for (int i = 0; i < endIdxNumOne; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int firstNum = nums[i];

      List<Integer> quadruplet = new ArrayList<>();
      quadruplet.add(firstNum);

      int firstIdxOfNumTwo = i + 1;
      for (int j = firstIdxOfNumTwo; j < endIdxNumTwo; j++) {
        if (j != firstIdxOfNumTwo && nums[j] == nums[j - 1]) {
          continue;
        }

        int secondNum = nums[j];
        long remain = target - ((long) firstNum + secondNum);

        int left = j + 1;
        int right = length - 1;

        while (left < right) {
          long sum = nums[left] + nums[right];
          if (sum == remain) {
            // Add mew quadruplet
            quadruplet.add(secondNum);
            quadruplet.add(nums[left]);
            quadruplet.add(nums[right]);

            quadruplets.add(quadruplet);

            // Reset quadruplet to prepare for next quadruplet
            quadruplet = new ArrayList<>();
            quadruplet.add(firstNum);

            int leftVal = nums[left];

            left++;
            while (left < right && nums[left] == leftVal) {
              left++;
            }
          } else if (sum > remain) {
            right--;
          } else {
            left++;
          }
        }
      }
    }

    return quadruplets;
  }

  public static void main(String[] args) {
    FourSum handler = new FourSum();
    System.out.println(handler.fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
  }
}
