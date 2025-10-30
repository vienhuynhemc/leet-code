
public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int[] ans = new int[2];
        int n = grid.length;
        final boolean[] existed = new boolean[n * n];

        int actualSum = 0;
        int expectSum = 0;
        int range = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];

                if (existed[grid[i][j] - 1]) {
                    ans[0] = grid[i][j];
                } else {
                    existed[grid[i][j] - 1] = true;
                }

                expectSum += range++;
            }
        }

        ans[1] = expectSum - (actualSum - ans[0]);

        return ans;
    }

    public static void main(String[] args) {
        final FindMissingAndRepeatedValues tester = new FindMissingAndRepeatedValues();
        tester.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}});
    }

}
