/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarrayI {

  public int longestBalanced(int[] nums) {
    int result = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      int oddCount = 0;
      int evenCount = 0;
      final Set<Integer> distinctNums = new HashSet<>();

      for (int j = i; j < nums.length; j++) {
        if (!distinctNums.contains(nums[j])) {
          final boolean isOdd = nums[j] % 2 == 1;
          oddCount += isOdd ? 1 : 0;
          evenCount += isOdd ? 0 : 1;
          distinctNums.add(nums[j]);
        }

        if (oddCount == evenCount) result = Math.max(result, j - i + 1);
      }
    }

    return result;
  }

  static void main() {
    final var test = new LongestBalancedSubarrayI();
    System.out.println(test.longestBalanced(new int[] { 10, 6, 10, 7 }));
  }
}
