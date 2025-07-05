package src.main.java;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) {
            return findOnlyWay(obstacleGrid);
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] data = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    data[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                int value = 0;
                if (i + 1 < m && data[i + 1][j] != -1) {
                    value += data[i + 1][j];
                }
                if (j + 1 < n && data[i][j + 1] != -1) {
                    value += data[i][j + 1];
                }
                data[i][j] = value;
            }
        }
        return data[0][0];
    }

    private int findOnlyWay(int[][] obstacleGrid) {
        for (int[] nums : obstacleGrid) {
            for (int num : nums) {
                if (num == 1) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        UniquePaths2 uniquePaths2 = new UniquePaths2();
        System.out.println(uniquePaths2.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePaths2.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

}
