/* vienhuynhemc */
import helper.LogTimeExecute;

public class UniquePaths {

  public int uniquePaths(int m, int n) {
    if (m == 1 || n == 1) {
      return 1;
    }
    int[][] data = new int[m][n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int value = 0;
        if (i + 1 < m) {
          value += data[i + 1][j];
        }
        if (j + 1 < n) {
          value += data[i][j + 1];
        }
        data[i][j] = value == 0 ? 1 : value;
      }
    }
    return data[0][0];
  }

  public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
    System.out.println(uniquePaths.uniquePaths(1, 1));
    System.out.println(uniquePaths.uniquePaths(3, 7));
    System.out.println(uniquePaths.uniquePaths(3, 2));
    LogTimeExecute.getInstance().log(unused -> uniquePaths.uniquePaths(51, 9));
  }
}
