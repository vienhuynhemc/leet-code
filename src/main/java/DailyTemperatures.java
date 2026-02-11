/* vienhuynhemc */
import java.util.Stack;

public class DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    final Stack<Integer> increaseStack = new Stack<>();
    final int[] result = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      while (!increaseStack.isEmpty() && temperatures[i] > temperatures[increaseStack.peek()]) {
        final int index = increaseStack.pop();
        result[index] = i - index;
      }

      increaseStack.push(i);
    }

    while (!increaseStack.isEmpty()) result[increaseStack.pop()] = 0;

    return result;
  }
}
