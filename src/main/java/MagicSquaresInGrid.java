/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {

  public int numMagicSquaresInside(int[][] grid) {
    final int row = grid.length;
    final int col = grid[0].length;

    if (row < 3 || col < 3) {
      return 0;
    }

    int result = 0;
    for (int i = 0; i < row - 2; i++) {
      for (int j = 0; j < col - 2; j++) {
        final Set<Integer> nums = new HashSet<>();
        boolean isBreak = false;
        for (int i1 = i; i1 < i + 3; i1++) {
          int sum = 0;
          for (int j1 = j; j1 < j + 3; j1++) {
            final int cur = grid[i1][j1];
            if (cur == 0 || cur > 9 || nums.contains(cur)) {
              isBreak = true;
              break;
            }

            nums.add(cur);
            sum += cur;
          }

          if (isBreak || sum != 15) {
            isBreak = true;
            break;
          }
        }

        if (!isBreak) {
          int sumFirst = 0;
          int sumSecond = 0;
          for (int i1 = i; i1 < i + 3; i1++) {
            sumFirst += grid[i1][j + i1 - i];
            sumSecond += grid[i + (i + 2 - i1)][j + i1 - i];
          }
          if (sumFirst != 15 || sumSecond != 15) {
            isBreak = true;
          }
        }

        if (!isBreak) {
          for (int j1 = j; j1 < j + 3; j1++) {
            int sum = 0;
            for (int i1 = i; i1 < i + 3; i1++) {
              sum += grid[i1][j1];
            }
            if (sum != 15) {
              isBreak = true;
              break;
            }
          }
        }

        if (!isBreak) {
          result++;
        }
      }
    }

    return result;
  }

  static void main() {
    final MagicSquaresInGrid ms = new MagicSquaresInGrid();
    System.out.println(
      ms.numMagicSquaresInside(
        new int[][] { { 3, 2, 9, 2, 7 }, { 6, 1, 8, 4, 2 }, { 7, 5, 3, 2, 7 }, { 2, 9, 4, 9, 6 }, { 4, 3, 8, 2, 5 } }
      )
    );
  }
}
