/* vienhuynhemc */
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    char[] sChar = s.toCharArray();
    int length = sChar.length;

    boolean[] removes = new boolean[length];
    final Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < length; i++) {
      char c = sChar[i];
      if (c == '(') {
        stack.push(i);
      } else if (c == ')') {
        if (stack.isEmpty()) {
          removes[i] = true;
        } else {
          stack.pop();
        }
      }
    }

    while (!stack.isEmpty()) {
      removes[stack.pop()] = true;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (!removes[i]) {
        sb.append(sChar[i]);
      }
    }

    return sb.toString();
  }
}
