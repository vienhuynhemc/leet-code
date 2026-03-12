/* vienhuynhemc */
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

  public int orangesRotting(int[][] grid) {
    final Queue<int[]> queue = new LinkedList<>();
    int freshOranges = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) queue.add(new int[] { i, j });
        if (grid[i][j] == 1) freshOranges++;
      }
    }

    if (queue.isEmpty()) return freshOranges == 0 ? 0 : -1;

    int elapseMins = 0;
    while (!queue.isEmpty()) {
      int currentSize = queue.size();

      while (currentSize-- > 0) {
        final int[] position = queue.poll();
        rottingOranges(grid, position[0], position[1], queue);
      }

      elapseMins++;
    }

    for (int[] ints : grid) for (int anInt : ints) if (anInt == 1) return -1;

    return elapseMins - 1;
  }

  private void rottingOranges(int[][] grid, int x, int y, Queue<int[]> queue) {
    if (x > 0 && grid[x - 1][y] == 1) {
      grid[x - 1][y] = 2;
      queue.add(new int[] { x - 1, y });
    }
    if (x < grid.length - 1 && grid[x + 1][y] == 1) {
      grid[x + 1][y] = 2;
      queue.add(new int[] { x + 1, y });
    }
    if (y > 0 && grid[x][y - 1] == 1) {
      grid[x][y - 1] = 2;
      queue.add(new int[] { x, y - 1 });
    }
    if (y < grid[x].length - 1 && grid[x][y + 1] == 1) {
      grid[x][y + 1] = 2;
      queue.add(new int[] { x, y + 1 });
    }
  }
}
