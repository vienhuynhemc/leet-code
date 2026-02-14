/* vienhuynhemc */
public class ChampagneTower {

  public double champagneTower(int poured, int query_row, int query_glass) {
    final double[][] dp = new double[query_row + 1][query_row + 1];
    dp[0][0] = poured;

    int row = 0;
    while (row++ < query_row) {
      for (int col = 0; col <= row; col++) {
        double overLiquid = 0;

        if (dp[row - 1][col] > 1) overLiquid += (dp[row - 1][col] - 1) / 2;
        if (col - 1 >= 0 && dp[row - 1][col - 1] > 1) overLiquid += (dp[row - 1][col - 1] - 1) / 2;

        dp[row][col] = overLiquid;
      }
    }

    return Math.min(dp[query_row][query_glass], 1);
  }

  static void main() {
    final var test = new ChampagneTower();
    System.out.println(test.champagneTower(1, 1, 1));
  }
}
