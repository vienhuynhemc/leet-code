/* vienhuynhemc */
import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {

  public int maxDotProduct(int[] nums1, int[] nums2) {
    final int[][] dp = new int[nums1.length][nums2.length];
    for (int[] ints : dp) {
      Arrays.fill(ints, Integer.MIN_VALUE);
    }
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int take = nums1[i] * nums2[j];
        if (i > 0 && j > 0) {
          take = Math.max(take, dp[i - 1][j - 1] + take);
        }

        int skip = Integer.MIN_VALUE;
        if (i > 0) {
          skip = Math.max(skip, dp[i - 1][j]);
        }
        if (j > 0) {
          skip = Math.max(skip, dp[i][j - 1]);
        }

        dp[i][j] = Math.max(take, skip);
      }
    }

    return dp[nums1.length - 1][nums2.length - 1];
  }
}
