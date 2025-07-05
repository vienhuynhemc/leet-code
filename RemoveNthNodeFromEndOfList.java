import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> array = new ArrayList<>();
        array.add(head);
        removeNthFromEnd(array, head.next);
        int indexWillRemove = array.size() - n;
        if (indexWillRemove == 0) {
            head = head.next;
            return head;
        }
        if (indexWillRemove == array.size() - 1) {
            array.get(array.size() - 2).next = null;
            return head;
        }
        array.get(indexWillRemove - 1).next = array.get(indexWillRemove).next;
        return head;
    }

    private void removeNthFromEnd(List<ListNode> data, ListNode head) {
        if (head == null) {
            return;
        }
        data.add(head);
        removeNthFromEnd(data, head.next);
    }

}
