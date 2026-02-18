/* vienhuynhemc */
import java.util.Arrays;

public class JumpGameII {

  public int jump(int[] nums) {
    final int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    dp[nums.length - 1] = 0;

    int index = nums.length - 1;
    while (index-- > 0) {
      for (int i = nums[index]; i >= 1; i--) {
        final int newIndex = index + i;
        if (newIndex < nums.length && dp[newIndex] != -1) {
          final int stepToReachEnd = dp[newIndex] + 1;
          dp[index] = dp[index] == -1 ? stepToReachEnd : Math.min(dp[index], stepToReachEnd);
        }
      }
    }

    return dp[0];
  }
}
