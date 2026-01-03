/* vienhuynhemc */
public class NumberOfWaysToPaintNx3Grid {

  private static final int MOD = 1000000007;

  public int numOfWays(int n) {
    final long[] dp3ColorCombination = new long[n];
    final long[] dp2ColorCombination = new long[n];

    dp3ColorCombination[0] = 6;
    dp2ColorCombination[0] = 6;

    for (int i = 1; i < n; i++) {
      dp3ColorCombination[i] = (dp3ColorCombination[i - 1] * 2 + dp2ColorCombination[i - 1] * 2) % MOD;
      dp2ColorCombination[i] = (dp3ColorCombination[i - 1] * 2 + dp2ColorCombination[i - 1] * 3) % MOD;
    }

    return (int) ((dp3ColorCombination[n - 1] + dp2ColorCombination[n - 1]) % MOD);
  }
}
