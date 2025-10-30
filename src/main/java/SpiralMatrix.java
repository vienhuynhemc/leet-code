/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    return spiralOrder(matrix, new ArrayList<>(), 0, 0, 0, 0, 0, 0, matrix.length * matrix[0].length);
  }

  private List<Integer> spiralOrder(
    int[][] matrix,
    List<Integer> result,
    int direction,
    int top,
    int right,
    int bottom,
    int left,
    int current,
    int max
  ) {
    if (current == max) {
      return result;
    }
    if (direction == 0) {
      for (int i = left; i <= matrix[0].length - 1 - right; i++) {
        result.add(matrix[top][i]);
        current++;
      }
      return spiralOrder(matrix, result, 1, top + 1, right, bottom, left, current, max);
    }
    if (direction == 1) {
      for (int i = top; i <= matrix.length - 1 - bottom; i++) {
        result.add(matrix[i][matrix[0].length - 1 - right]);
        current++;
      }
      return spiralOrder(matrix, result, 2, top, right + 1, bottom, left, current, max);
    }
    if (direction == 2) {
      for (int i = matrix[0].length - 1 - right; i >= left; i--) {
        result.add(matrix[matrix.length - 1 - bottom][i]);
        current++;
      }
      return spiralOrder(matrix, result, 3, top, right, bottom + 1, left, current, max);
    }
    for (int i = matrix.length - 1 - bottom; i >= top; i--) {
      result.add(matrix[i][left]);
      current++;
    }
    return spiralOrder(matrix, result, 0, top, right, bottom, left + 1, current, max);
  }

  public static void main(String[] args) {
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    System.out.println(spiralMatrix.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
    System.out.println(spiralMatrix.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
  }
}
