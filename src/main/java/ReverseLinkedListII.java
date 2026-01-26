/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;
import model.ListNode;

public class ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    final List<ListNode> nodes = new ArrayList<>();
    ListNode prev = null;
    ListNode next = null;

    ListNode headCopied = head;
    boolean isMatchLeft = false;
    int position = 1;
    while (headCopied != null) {
      if (!isMatchLeft) {
        if (position == left) {
          isMatchLeft = true;
          continue;
        }

        prev = headCopied;
        headCopied = headCopied.next;
        position++;
        continue;
      }

      nodes.add(headCopied);

      if (position == right) {
        next = headCopied.next;
        break;
      }
      headCopied = headCopied.next;
      position++;
    }

    for (int i = nodes.size() - 1; i > 0; i--) {
      nodes.get(i - 1).next = null;
      nodes.get(i).next = nodes.get(i - 1);
    }

    nodes.getFirst().next = next;
    if (prev != null) prev.next = nodes.getLast();

    return prev != null ? head : nodes.getLast();
  }

  static void main() {
    final ReverseLinkedListII r = new ReverseLinkedListII();
    final ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(r.reverseBetween(head, 1, 4));
  }
}
