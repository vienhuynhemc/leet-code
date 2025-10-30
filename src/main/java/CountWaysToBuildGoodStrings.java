/* vienhuynhemc */
import helper.LogTimeExecute;

public class CountWaysToBuildGoodStrings {

  private static final int MOD = (int) (Math.pow(10, 9) + 7);

  public int countGoodStrings(int low, int high, int zero, int one) {
    int[] dp = new int[high + 1];
    dp[0] = 1;
    int result = 0;
    for (int i = 1; i < high + 1; i++) {
      if (i - zero >= 0) {
        dp[i] += dp[i - zero];
      }
      if (i - one >= 0) {
        dp[i] += dp[i - one];
      }
      dp[i] %= MOD;
      if (low <= i && i <= high) {
        result += dp[i];
        result %= MOD;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    CountWaysToBuildGoodStrings countWaysToBuildGoodStrings = new CountWaysToBuildGoodStrings();
    System.out.println(countWaysToBuildGoodStrings.countGoodStrings(3, 3, 1, 1));
    System.out.println(countWaysToBuildGoodStrings.countGoodStrings(2, 3, 1, 2));
    LogTimeExecute.getInstance().log(unused -> countWaysToBuildGoodStrings.countGoodStrings(2, 30, 1, 2));
    LogTimeExecute.getInstance().log(unused -> countWaysToBuildGoodStrings.countGoodStrings(200, 200, 10, 1));
  }
}
