/* vienhuynhemc */
public class MaximumMatrixSum {

  public long maxMatrixSum(int[][] matrix) {
    long result = 0;
    int positiveCount = 0;
    int smallestAbsNum = Integer.MAX_VALUE;

    for (int[] ints : matrix) {
      for (int anInt : ints) {
        int absNum = Math.abs(anInt);
        if (absNum < smallestAbsNum) {
          smallestAbsNum = absNum;
        }

        if (anInt >= 0) {
          result += anInt;
          continue;
        }

        positiveCount++;
        result += anInt * -1;
      }
    }

    if (positiveCount % 2 == 1) {
      result += ((long) smallestAbsNum) * -2;
    }

    return result;
  }
}
