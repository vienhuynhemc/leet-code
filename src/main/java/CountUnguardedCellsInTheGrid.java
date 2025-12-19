/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class CountUnguardedCellsInTheGrid {

  private record Pair(int first, int second) {}

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    final Set<Pair> guardsSet = new HashSet<>();
    for (int[] guard : guards) {
      guardsSet.add(new Pair(guard[0], guard[1]));
    }

    final Set<Pair> wallsSet = new HashSet<>();
    for (int[] wall : walls) {
      wallsSet.add(new Pair(wall[0], wall[1]));
    }

    final boolean[][] guarded = new boolean[m][n];

    for (int[] guard : guards) {
      guarded[guard[0]][guard[1]] = true;

      int moveToTop = guard[0] - 1;
      while (moveToTop >= 0) {
        guarded[moveToTop][guard[1]] = true;

        final Pair pair = new Pair(moveToTop, guard[1]);
        if (guardsSet.contains(pair) || wallsSet.contains(pair)) {
          break;
        }

        moveToTop--;
      }

      int moveToBottom = guard[0] + 1;
      while (moveToBottom < m) {
        guarded[moveToBottom][guard[1]] = true;

        final Pair pair = new Pair(moveToBottom, guard[1]);
        if (guardsSet.contains(pair) || wallsSet.contains(pair)) {
          break;
        }

        moveToBottom++;
      }

      int moveToLeft = guard[1] - 1;
      while (moveToLeft >= 0) {
        guarded[guard[0]][moveToLeft] = true;

        final Pair pair = new Pair(guard[0], moveToLeft);
        if (guardsSet.contains(pair) || wallsSet.contains(pair)) {
          break;
        }

        moveToLeft--;
      }

      int moveToRight = guard[1] + 1;
      while (moveToRight < n) {
        guarded[guard[0]][moveToRight] = true;

        final Pair pair = new Pair(guard[0], moveToRight);
        if (guardsSet.contains(pair) || wallsSet.contains(pair)) {
          break;
        }

        moveToRight++;
      }
    }

    for (int[] wall : walls) {
      guarded[wall[0]][wall[1]] = true;
    }

    int result = 0;
    for (boolean[] row : guarded) {
      for (boolean i : row) {
        if (!i) {
          result++;
        }
      }
    }

    return result;
  }

  static void main() {
    final var handler = new CountUnguardedCellsInTheGrid();
    System.out.println(
      handler.countUnguarded(
        7,
        1,
        new int[][] { { 0, 0 }, { 4, 0 }, { 1, 0 } },
        new int[][] { { 6, 0 }, { 5, 0 }, { 3, 0 } }
      )
    );
  }
}
