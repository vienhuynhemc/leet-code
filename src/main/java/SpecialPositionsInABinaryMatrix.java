/* vienhuynhemc */
public class SpecialPositionsInABinaryMatrix {

  public int numSpecial(int[][] mat) {
    final int[] bitOneCountsForRows = new int[mat.length];
    final int[] bitOneCountsForCols = new int[mat[0].length];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        bitOneCountsForCols[j] += mat[i][j];
        bitOneCountsForRows[i] += mat[i][j];
      }
    }

    int result = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1 && bitOneCountsForRows[i] == 1 && bitOneCountsForCols[j] == 1) result++;
      }
    }

    return result;
  }
}
