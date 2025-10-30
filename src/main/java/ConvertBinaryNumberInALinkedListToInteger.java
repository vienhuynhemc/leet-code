/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;
import model.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

  public int getDecimalValue(ListNode head) {
    final List<Integer> data = new ArrayList<>();

    int length = 0;
    while (head != null) {
      if (head.val == 1) {
        data.add(length);
      }

      length++;
      head = head.next;
    }

    int result = 0;
    for (Integer item : data) {
      result += (int) Math.pow(2, length - 1 - item);
    }

    return result;
  }
}
