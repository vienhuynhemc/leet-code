/* vienhuynhemc */
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

  public int[] exclusiveTime(int n, List<String> logs) {
    int[] result = new int[n];

    final Stack<Integer> callStack = new Stack<>();

    int index = 0;
    for (String log : logs) {
      final String[] signal = log.split(":");
      final int id = Integer.parseInt(signal[0]);
      final int time = Integer.parseInt(signal[2]);

      if (signal[1].equals("start")) {
        if (!callStack.isEmpty()) {
          result[callStack.peek()] += time - index;
          index = time;
        }

        callStack.push(id);
      } else if (signal[1].equals("end")) {
        result[callStack.peek()] += time - index + 1;
        index = time + 1;

        callStack.pop();
      }
    }

    return result;
  }

  static void main() {
    final var test = new ExclusiveTimeOfFunctions();
    System.out.println(Arrays.toString(test.exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
  }
}
