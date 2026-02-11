/* vienhuynhemc */
import java.util.Stack;

public class LargestRectangleInHistogram {

  public int largestRectangleArea(int[] heights) {
    final Stack<Integer> decreaseStack = new Stack<>();

    int limitLeftObstacle = 0;
    int result = 0;

    for (int i = 0; i <= heights.length; i++) {
      final boolean isLastColumn = i == heights.length;
      int currentHeight = isLastColumn ? 0 : heights[i];

      while (!decreaseStack.isEmpty() && currentHeight < heights[decreaseStack.peek()]) {
        final int index = decreaseStack.pop();
        final int leftObstacle = decreaseStack.isEmpty() ? limitLeftObstacle : decreaseStack.peek() + 1;
        final int area = (i - leftObstacle) * heights[index];
        result = Math.max(result, area);
      }

      if (isLastColumn) break;
      if (heights[i] == 0) limitLeftObstacle = i + 1;
      else decreaseStack.push(i);
    }

    return result;
  }

  static void main() {
    final var test = new LargestRectangleInHistogram();
    System.out.println(test.largestRectangleArea(new int[] { 9, 0, 3, 0, 3, 5, 4, 7, 9 }));
  }
}
