package src.main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        row.forEach(integer -> matrix[integer] = new int[matrix[0].length]);
        col.forEach(integer -> {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        });
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] array = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixZeroes.setZeroes(array);
        System.out.println(Arrays.deepToString(array));
    }

}
