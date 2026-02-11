/* vienhuynhemc */
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {

  public int[] finalPrices(int[] prices) {
    final Stack<Integer> decreaseStack = new Stack<>();
    final int[] result = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
      while (!decreaseStack.isEmpty() && prices[i] <= prices[decreaseStack.peek()]) {
        final int index = decreaseStack.pop();
        result[index] = prices[index] - prices[i];
      }

      decreaseStack.push(i);
    }

    while (!decreaseStack.isEmpty()) {
      final int index = decreaseStack.pop();
      result[index] = prices[index];
    }

    return result;
  }
}
