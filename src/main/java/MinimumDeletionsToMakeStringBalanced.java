/* vienhuynhemc */
public class MinimumDeletionsToMakeStringBalanced {

  public int minimumDeletions(String s) {
    final char[] chars = s.toCharArray();

    final int[] dp = new int[chars.length + 1];
    int countB = 0;

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'a') dp[i + 1] = Math.min(dp[i] + 1, countB);
      else {
        countB++;
        dp[i + 1] = dp[i];
      }
    }

    return dp[chars.length];
  }
}
