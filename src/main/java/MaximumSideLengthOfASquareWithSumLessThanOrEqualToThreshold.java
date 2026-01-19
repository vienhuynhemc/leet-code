/* vienhuynhemc */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

  public int maxSideLength(int[][] mat, int threshold) {
    final int[][] prefixSum = getPrefixSum(mat);

    int result = 0;
    int left = 1;
    int right = Math.min(mat.length, mat[0].length);

    while (left <= right) {
      int mid = (left + right) / 2;

      if (isLengthValid(prefixSum, threshold, mid)) {
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return result;
  }

  private boolean isLengthValid(int[][] prefixSum, int threshold, int k) {
    for (int i = k - 1; i < prefixSum.length; i++) {
      for (int j = k - 1; j < prefixSum[0].length; j++) {
        int sum = prefixSum[i][j];
        if (i >= k) {
          sum -= prefixSum[i - k][j];
        }
        if (j >= k) {
          sum -= prefixSum[i][j - k];
        }
        if (i >= k && j >= k) {
          sum += prefixSum[i - k][j - k];
        }

        if (sum <= threshold) {
          return true;
        }
      }
    }

    return false;
  }

  private int[][] getPrefixSum(int[][] mat) {
    final int[][] prefixSum = new int[mat.length][mat[0].length];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (i == 0 && j == 0) {
          prefixSum[i][j] = mat[i][j];
          continue;
        }

        if (i == 0) {
          prefixSum[i][j] = mat[i][j] + prefixSum[i][j - 1];
          continue;
        }

        if (j == 0) {
          prefixSum[i][j] = mat[i][j] + prefixSum[i - 1][j];
          continue;
        }

        prefixSum[i][j] = mat[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
      }
    }

    return prefixSum;
  }

  static void main() {
    final var tester = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
    System.out.println(
      tester.maxSideLength(new int[][] { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } }, 4)
    );
  }
}
