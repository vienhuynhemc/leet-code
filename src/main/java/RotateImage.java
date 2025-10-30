
import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int[][] workplace = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                workplace[i][j] = matrix[matrix[i].length - j - 1][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(workplace[i], 0, matrix[i], 0, matrix[i].length);
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(arr1);
        System.out.println(Arrays.deepToString(arr1));
        int[][] arr2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotateImage.rotate(arr2);
        System.out.println(Arrays.deepToString(arr2));
    }

}
