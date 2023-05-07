public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int bottom = -1;
                int right = -1;
                if (i + 1 < m) {
                    bottom = grid[i + 1][j];
                }
                if (j + 1 < n) {
                    right = grid[i][j + 1];
                }
                if (bottom != -1 && right != -1) {
                    grid[i][j] = grid[i][j] + Math.min(bottom, right);
                    continue;
                }
                if (right != -1) {
                    grid[i][j] = grid[i][j] + right;
                    continue;
                }
                if (bottom != -1) {
                    grid[i][j] = grid[i][j] + bottom;
                }
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(minimumPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(minimumPathSum.minPathSum(new int[][]{{10}}));
    }

}
