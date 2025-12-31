/* vienhuynhemc */
public class LastDayWhereYouCanStillCross {

  public int latestDayToCross(int row, int col, int[][] cells) {
    final int[] union = new int[row * col + 2];
    for (int i = 0; i < union.length; i++) {
      union[i] = i;
    }

    final int TOP = row * col;
    final int BOTTOM = row * col + 1;

    final int[][] board = new int[row][col];
    for (int i = cells.length - 1; i >= 0; i--) {
      final int rowIndex = cells[i][0] - 1;
      final int colIndex = cells[i][1] - 1;
      board[rowIndex][colIndex] = 1;

      final int currentId = rowIndex * col + colIndex;

      if (rowIndex > 0 && board[rowIndex - 1][colIndex] == 1) {
        union(currentId, (rowIndex - 1) * col + colIndex, union);
      }

      if (rowIndex == 0) {
        union(currentId, TOP, union);
      }

      if (rowIndex < row - 1 && board[rowIndex + 1][colIndex] == 1) {
        union(currentId, (rowIndex + 1) * col + colIndex, union);
      }

      if (rowIndex == row - 1) {
        union(currentId, BOTTOM, union);
      }

      if (colIndex < col - 1 && board[rowIndex][colIndex + 1] == 1) {
        union(currentId, rowIndex * col + colIndex + 1, union);
      }

      if (colIndex > 0 && board[rowIndex][colIndex - 1] == 1) {
        union(currentId, rowIndex * col + colIndex - 1, union);
      }

      if (find(TOP, union) == find(BOTTOM, union)) {
        return i;
      }
    }

    return 0;
  }

  private void union(int first, int second, int[] union) {
    union[find(second, union)] = find(first, union);
  }

  private int find(int id, int[] union) {
    if (union[id] != id) {
      union[id] = find(union[id], union);
    }

    return union[id];
  }

  static void main() {
    final var test = new LastDayWhereYouCanStillCross();
    System.out.println(
      test.latestDayToCross(
        3,
        3,
        new int[][] { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 2, 2 }, { 1, 1 }, { 1, 3 }, { 2, 3 }, { 3, 2 }, { 3, 1 } }
      )
    );
  }
}
