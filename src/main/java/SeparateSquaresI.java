/* vienhuynhemc */
public class SeparateSquaresI {

  public double separateSquares(int[][] squares) {
    double minPoint = Integer.MAX_VALUE;
    double maxPoint = Integer.MIN_VALUE;
    long totalArea = 0;

    for (int[] square : squares) {
      totalArea += (long) square[2] * square[2];
      minPoint = Math.min(minPoint, square[1]);
      maxPoint = Math.max(maxPoint, square[1] + square[2]);
    }

    final double belowArea = totalArea / 2.0;
    double left = minPoint;
    double right = maxPoint;
    for (int i = 0; i < 80; i++) {
      final double mid = (left + right) / 2;
      final double totalBelowArea = totalBelowArea(mid, squares);

      if (totalBelowArea < belowArea) {
        left = mid;
      } else {
        right = mid;
      }
    }

    return (left + right) / 2;
  }

  private double totalBelowArea(double y, int[][] squares) {
    double area = 0;

    for (int[] square : squares) {
      final int top = square[1] + square[2];
      final int bottom = square[1];

      if (y >= top) {
        area += (double) square[2] * square[2];
      } else if (y >= bottom) {
        area += (y - bottom) * square[2];
      }
    }

    return area;
  }

  static void main() {
    final var tester = new SeparateSquaresI();
    System.out.println(tester.separateSquares(new int[][] { { 0, 0, 1 }, { 2, 2, 1 } }));
  }
}
