/* vienhuynhemc */
import model.ListNode;

public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode next = head.next;
    if (next == null) {
      return head;
    }
    head.next = null;
    return reverseList(next, head);
  }

  private ListNode reverseList(ListNode head, ListNode before) {
    ListNode next = head.next;
    head.next = before;
    if (next == null) {
      return head;
    }
    return reverseList(next, head);
  }
}
