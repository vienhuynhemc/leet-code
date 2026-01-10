/* vienhuynhemc */
public class MinimumASCIIDeleteSumForTwoStrings {

  public int minimumDeleteSum(String s1, String s2) {
    final char[] chars1 = s1.toCharArray();
    final char[] chars2 = s2.toCharArray();

    final int[][] dp = new int[chars1.length + 1][chars2.length + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }

        if (i == 0) {
          dp[i][j] = dp[i][j - 1] + chars2[j - 1];
          continue;
        }

        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + chars1[i - 1];
          continue;
        }

        final char prevS1Char = chars1[i - 1];
        final char prevS2Char = chars2[j - 1];
        if (prevS1Char == prevS2Char) {
          dp[i][j] = dp[i - 1][j - 1];
          continue;
        }

        dp[i][j] = Math.min(dp[i - 1][j] + prevS1Char, dp[i][j - 1] + prevS2Char);
      }
    }

    return dp[chars1.length][chars2.length];
  }

  static void main() {
    final var tester = new MinimumASCIIDeleteSumForTwoStrings();
    System.out.println(tester.minimumDeleteSum("sea", "eat"));
  }
}
