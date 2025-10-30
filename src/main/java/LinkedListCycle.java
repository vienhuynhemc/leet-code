
import src.main.java.model.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
