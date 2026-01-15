/* vienhuynhemc */
import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {

  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    final int maxDistanceHorizontal = findMaxDistanceCanBeObtained(hBars);
    final int maxDistanceVertical = findMaxDistanceCanBeObtained(vBars);
    final int minDistance = Math.min(maxDistanceHorizontal, maxDistanceVertical);

    return minDistance * minDistance;
  }

  private int findMaxDistanceCanBeObtained(int[] bar) {
    int maxSoFar = 2;
    int currentDistance = 2;
    for (int i = 1; i < bar.length; i++) {
      if (bar[i] == bar[i - 1] + 1) {
        currentDistance++;
        continue;
      }

      maxSoFar = Math.max(maxSoFar, currentDistance);
      currentDistance = 2;
    }

    return Math.max(maxSoFar, currentDistance);
  }
}
