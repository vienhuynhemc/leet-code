/* vienhuynhemc */
import model.ListNode;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

  public ListNode removeZeroSumSublists(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode current = head;
    int sum = 0;

    while (current != null) {
      sum += current.val;

      if (sum == 0) {
        head = current.next;
        return removeZeroSumSublists(head);
      }

      current = current.next;
    }

    head.next = removeZeroSumSublists(head.next);
    return head;
  }

  static void main() {
    final var handler = new RemoveZeroSumConsecutiveNodesFromLinkedList();
    System.out.println(
      handler.removeZeroSumSublists(
        new ListNode(
          1,
          new ListNode(0, new ListNode(0, new ListNode(-1, new ListNode(2, new ListNode(-1, new ListNode(0))))))
        )
      )
    );
  }
}
