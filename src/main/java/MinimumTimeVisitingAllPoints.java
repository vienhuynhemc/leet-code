/* vienhuynhemc */
public class MinimumTimeVisitingAllPoints {

  public int minTimeToVisitAllPoints(int[][] points) {
    int result = 0;

    for (int i = 1; i < points.length; i++) {
      int gapX = Math.abs(points[i][0] - points[i - 1][0]);
      int gapY = Math.abs(points[i][1] - points[i - 1][1]);

      result += Math.max(gapX, gapY);
    }

    return result;
  }
}
