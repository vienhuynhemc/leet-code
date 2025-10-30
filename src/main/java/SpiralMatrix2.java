

import helper.LogTimeExecute;

import java.util.Arrays;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        return spiralOrder(new int[n][n], 0, 0, 0, 0, 0, 1, n * n + 1);
    }

    private int[][] spiralOrder(int[][] result,
                                int direction,
                                int top,
                                int right,
                                int bottom,
                                int left,
                                int value,
                                int max) {
        if (value == max) {
            return result;
        }
        if (direction == 0) {
            for (int i = left; i <= result[0].length - 1 - right; i++) {
                result[top][i] = value;
                value++;
            }
            return spiralOrder(result, 1, top + 1, right, bottom, left, value, max);
        }
        if (direction == 1) {
            for (int i = top; i <= result.length - 1 - bottom; i++) {
                result[i][result[0].length - 1 - right] = value;
                value++;
            }
            return spiralOrder(result, 2, top, right + 1, bottom, left, value, max);
        }
        if (direction == 2) {
            for (int i = result[0].length - 1 - right; i >= left; i--) {
                result[result.length - 1 - bottom][i] = value;
                value++;
            }
            return spiralOrder(result, 3, top, right, bottom + 1, left, value, max);
        }
        for (int i = result.length - 1 - bottom; i >= top; i--) {
            result[i][left] = value;
            value++;
        }
        return spiralOrder(result, 0, top, right, bottom, left + 1, value, max);
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(1)));
        System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(2)));
        System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(3)));
        System.out.println(Arrays.deepToString(spiralMatrix2.generateMatrix(4)));
        LogTimeExecute.getInstance().log(unused -> spiralMatrix2.generateMatrix(20));
    }

}
