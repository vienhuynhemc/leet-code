public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }
        boolean[][] checks = new boolean[mat.length][mat.length];
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            checks[i][i] = true;
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            if (checks[i][mat.length - 1 - i]) {
                continue;
            }
            sum += mat[i][mat.length - 1 - i];
        }
        return sum;
    }

}
