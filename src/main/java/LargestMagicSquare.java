/* vienhuynhemc */
public class LargestMagicSquare {

  public int largestMagicSquare(int[][] grid) {
    final int[][] prefixSumRow = getPrefixSumRow(grid);
    final int[][] prefixSumCol = getPrefixSumCol(grid);
    final int[][] prefixSumDiag = getPrefixSumDiag(grid);
    final int[][] prefixSumAntiDiag = getPrefixSumAntiDiag(grid);

    int k = Math.min(grid.length, grid[0].length);
    while (k > 1) {
      for (int i = grid.length - 1; i >= k - 1; i--) {
        for (int j = grid[0].length - 1; j >= k - 1; j--) {
          final int target = getPrefixSumRow(i - k + 1, j, k, prefixSumRow);

          boolean isViolate = false;
          for (int m = i - k + 2; m <= i; m++) {
            if (getPrefixSumRow(m, j, k, prefixSumRow) != target) {
              isViolate = true;
              break;
            }
          }
          if (isViolate) {
            continue;
          }

          for (int m = j - k + 1; m <= j; m++) {
            if (getPrefixSumCol(i, m, k, prefixSumCol) != target) {
              isViolate = true;
              break;
            }
          }
          if (isViolate) {
            continue;
          }

          if (
            getPrefixSumDiag(i, j, k, prefixSumDiag) != target ||
            getPrefixSumAntiDiag(i, j, k, prefixSumAntiDiag) != target
          ) {
            continue;
          }

          return k;
        }
      }
      k--;
    }

    return k;
  }

  private int[][] getPrefixSumRow(int[][] grid) {
    final int[][] prefixSumRow = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      int sum = 0;
      for (int j = 0; j < grid[0].length; j++) {
        sum += grid[i][j];
        prefixSumRow[i][j] = sum;
      }
    }

    return prefixSumRow;
  }

  private int[][] getPrefixSumCol(int[][] grid) {
    final int[][] prefixSumCol = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid[0].length; i++) {
      int sum = 0;
      for (int j = 0; j < grid.length; j++) {
        sum += grid[j][i];
        prefixSumCol[j][i] = sum;
      }
    }

    return prefixSumCol;
  }

  private int[][] getPrefixSumDiag(int[][] grid) {
    final int[][] prefixSumDiag = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i == 0 || j == 0) {
          prefixSumDiag[i][j] = grid[i][j];
          continue;
        }

        prefixSumDiag[i][j] = prefixSumDiag[i - 1][j - 1] + grid[i][j];
      }
    }

    return prefixSumDiag;
  }

  private int[][] getPrefixSumAntiDiag(int[][] grid) {
    final int[][] prefixSumAntiDiag = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        if (i == 0 || j == grid[0].length - 1) {
          prefixSumAntiDiag[i][j] = grid[i][j];
          continue;
        }

        prefixSumAntiDiag[i][j] = prefixSumAntiDiag[i - 1][j + 1] + grid[i][j];
      }
    }

    return prefixSumAntiDiag;
  }

  private int getPrefixSumRow(int i, int j, int k, int[][] array) {
    return j >= k ? array[i][j] - array[i][j - k] : array[i][j];
  }

  private int getPrefixSumCol(int i, int j, int k, int[][] array) {
    return i >= k ? array[i][j] - array[i - k][j] : array[i][j];
  }

  private int getPrefixSumDiag(int i, int j, int k, int[][] array) {
    return j >= k && i >= k ? array[i][j] - array[i - k][j - k] : array[i][j];
  }

  private int getPrefixSumAntiDiag(int i, int j, int k, int[][] array) {
    return i >= k && j <= array[i].length - 2 ? array[i][j - k + 1] - array[i - k][j + 1] : array[i][j - k + 1];
  }

  static void main() {
    final var tester = new LargestMagicSquare();
    System.out.println(
      tester.largestMagicSquare(
        new int[][] { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } }
      )
    );
  }
}
