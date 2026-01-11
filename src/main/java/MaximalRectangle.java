/* vienhuynhemc */
import java.util.Stack;

public class MaximalRectangle {

  public int maximalRectangle(char[][] matrix) {
    final int[][] dp = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        final int value = matrix[i][j] == '1' ? 1 : 0;
        if (i == 0) {
          dp[i][j] = value;
          continue;
        }

        dp[i][j] = value == 1 ? dp[i - 1][j] + value : 0;
      }
    }

    int result = 0;
    for (int[] ints : dp) {
      final Stack<Integer> stack = new Stack<>();
      for (int j = 0; j <= ints.length; j++) {
        final int height = j == ints.length ? 0 : ints[j];

        while (!stack.isEmpty() && height < ints[stack.peek()]) {
          final int curHeight = ints[stack.pop()];
          final int rightBoundary = j - 1;
          final int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
          final int width = rightBoundary - leftBoundary + 1;
          final int area = curHeight * width;

          result = Math.max(result, curHeight * width);
        }

        stack.push(j);
      }
    }

    return result;
  }

  static void main() {
    final var tester = new MaximalRectangle();
    System.out.println(
      tester.maximalRectangle(
        new char[][] {
          { '1', '0', '1', '0', '0' },
          { '1', '0', '1', '1', '1' },
          { '1', '1', '1', '1', '1' },
          { '1', '0', '0', '1', '0' },
        }
      )
    );
  }
}
