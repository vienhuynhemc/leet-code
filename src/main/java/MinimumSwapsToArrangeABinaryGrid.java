/* vienhuynhemc */
public class MinimumSwapsToArrangeABinaryGrid {

  public int minSwaps(int[][] grid) {
    final int[] trailingZeroCounts = new int[grid.length];
    for (int i = 0; i < grid.length; i++) {
      int trailingZeroCount = 0;
      for (int j = grid[i].length - 1; j >= 0; j--) {
        if (grid[i][j] == 0) trailingZeroCount++;
        else break;
      }
      trailingZeroCounts[i] = trailingZeroCount;
    }

    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      final int expectTrailingZeroCount = grid.length - i - 1;
      boolean isFoundValidRound = false;

      for (int j = i; j < trailingZeroCounts.length; j++) {
        if (trailingZeroCounts[j] >= expectTrailingZeroCount) {
          result += j - i;
          isFoundValidRound = true;

          bubbleUp(trailingZeroCounts, i, j);

          break;
        }
      }

      if (!isFoundValidRound) return -1;
    }

    return result;
  }

  private void bubbleUp(int[] grid, int i, int j) {
    final int tmp = grid[j];

    for (int k = j; k >= i + 1; k--) grid[k] = grid[k - 1];

    grid[i] = tmp;
  }
}
