/* vienhuynhemc */
import java.util.Stack;

public class MakeTheStringGreat {

  public String makeGood(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char aChar : chars) {
      if (stack.isEmpty()) {
        stack.push(aChar);
        continue;
      }

      if (Math.abs(aChar - stack.peek()) == 32) {
        stack.pop();
      } else {
        stack.push(aChar);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    MakeTheStringGreat handler = new MakeTheStringGreat();
    System.out.println(handler.makeGood("leEeetcode"));
  }
}
