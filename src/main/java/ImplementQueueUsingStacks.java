/* vienhuynhemc */
import java.util.Stack;

public class ImplementQueueUsingStacks {

  static class MyQueue {

    private final Stack<Integer> egress;
    private final Stack<Integer> ingress;

    public MyQueue() {
      egress = new Stack<>();
      ingress = new Stack<>();
    }

    public void push(int x) {
      ingress.push(x);
    }

    public int pop() {
      updateEgress();
      return egress.pop();
    }

    public int peek() {
      updateEgress();
      return egress.peek();
    }

    public boolean empty() {
      updateEgress();
      return egress.empty();
    }

    private void updateEgress() {
      if (egress.empty()) while (!ingress.empty()) egress.push(ingress.pop());
    }
  }
}
