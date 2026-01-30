/* vienhuynhemc */
import java.util.Stack;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    final Stack<Integer> tokensStack = new Stack<>();

    for (String token : tokens) {
      switch (token) {
        case "+": {
          final int b = tokensStack.pop();
          final int a = tokensStack.pop();
          tokensStack.push(a + b);
          break;
        }
        case "-": {
          final int b = tokensStack.pop();
          final int a = tokensStack.pop();
          tokensStack.push(a - b);
          break;
        }
        case "*": {
          final int b = tokensStack.pop();
          final int a = tokensStack.pop();
          tokensStack.push(a * b);
          break;
        }
        case "/": {
          final int b = tokensStack.pop();
          final int a = tokensStack.pop();
          tokensStack.push(a / b);
          break;
        }
        default:
          tokensStack.push(Integer.parseInt(token));
      }
    }

    return tokensStack.peek();
  }
}
