/* vienhuynhemc */
public class LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    final char[] chars1 = text1.toCharArray();
    final char[] chars2 = text2.toCharArray();

    final int[][] dp = new int[chars1.length][chars2.length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        final int point = chars1[i] == chars2[j] ? 1 : 0;
        if (i == 0 && j == 0) {
          dp[i][j] = point;
          continue;
        }

        if (i == 0) {
          dp[i][j] = Math.max(point, dp[i][j - 1]);
          continue;
        }

        if (j == 0) {
          dp[i][j] = Math.max(point, dp[i - 1][j]);
          continue;
        }

        if (point == 1) {
          dp[i][j] = dp[i - 1][j - 1] + point;
          continue;
        }

        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[chars1.length - 1][chars2.length - 1];
  }

  static void main() {
    final var tester = new LongestCommonSubsequence();
    System.out.println(tester.longestCommonSubsequence("abcde", "ace"));
  }
}
