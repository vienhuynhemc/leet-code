/* vienhuynhemc */
import java.util.Stack;

public class MinimumOperationsToConvertAllElementsToZero {

  public int minOperations(int[] nums) {
    final Stack<Integer> stack = new Stack<>();

    int result = 0;

    for (int num : nums) {
      if (num == 0) {
        result += stack.size();
        stack.clear();
        continue;
      }

      if (stack.isEmpty()) {
        stack.push(num);
        continue;
      }

      int prev = stack.peek();
      if (prev == num) {
        continue;
      }

      if (prev < num) {
        stack.push(num);
        continue;
      }

      while (!stack.isEmpty()) {
        prev = stack.peek();
        if (prev == num) {
          stack.pop();
          continue;
        }

        if (prev < num) {
          break;
        }

        stack.pop();
        result++;
      }

      stack.push(num);
    }

    result += stack.size();

    return result;
  }

  static void main() {
    final var handler = new MinimumOperationsToConvertAllElementsToZero();
    System.out.println(handler.minOperations(new int[] { 3, 1, 2, 1 }));
  }
}
