/* vienhuynhemc */
public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    int result = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '0') continue;

        removeIsLands(grid, i, j);
        result++;
      }
    }

    return result;
  }

  private void removeIsLands(char[][] grid, int x, int y) {
    if (grid[x][y] == '0') return;

    grid[x][y] = '0';
    if (x > 0) removeIsLands(grid, x - 1, y);
    if (x < grid.length - 1) removeIsLands(grid, x + 1, y);
    if (y > 0) removeIsLands(grid, x, y - 1);
    if (y < grid[x].length - 1) removeIsLands(grid, x, y + 1);
  }

  static void main() {
    final var tester = new NumberOfIslands();
    System.out.println(
      tester.numIslands(
        new char[][] {
          { '1', '1', '0', '0', '0' },
          { '1', '1', '0', '0', '0' },
          { '0', '0', '1', '0', '0' },
          { '0', '0', '0', '1', '1' },
        }
      )
    );
  }
}
