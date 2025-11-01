/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;
import model.ListNode;

public class DeleteNodesFromLinkedListPresentInArray {

  public ListNode modifiedList(int[] nums, ListNode head) {
    final Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    Integer firstVal = null;
    ListNode curr = head;
    while (curr != null) {
      final int value = curr.val;
      curr = curr.next;

      if (!set.contains(value)) {
        firstVal = value;
        break;
      }
    }

    if (firstVal == null) {
      return null;
    }

    final ListNode result = new ListNode(firstVal);
    ListNode tmp = result;

    while (curr != null) {
      final int value = curr.val;
      curr = curr.next;

      if (!set.contains(value)) {
        tmp.next = new ListNode(value);
        tmp = tmp.next;
      }
    }

    return result;
  }
}
