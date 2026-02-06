/* vienhuynhemc */
import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {

  public int minRemoval(int[] nums, int k) {
    Arrays.sort(nums);

    int windowSide = 1;

    int rightIndex = 1;
    int leftIndex = 0;

    while (rightIndex < nums.length) {
      while (leftIndex < rightIndex && (long) nums[leftIndex] * k < nums[rightIndex]) leftIndex++;
      windowSide = Math.max(windowSide, rightIndex - leftIndex + 1);
      rightIndex++;
    }

    return nums.length - windowSide;
  }

  static void main() {
    final var tester = new MinimumRemovalsToBalanceArray();
    System.out.println(tester.minRemoval(new int[] { 8, 99, 65, 16, 39 }, 3));
  }
}
