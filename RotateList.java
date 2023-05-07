import models.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        List<ListNode> data = new ArrayList<>();
        do {
            data.add(head);
            head = head.next;
        } while (head != null);
        int size = data.size();
        int realK = k % size;
        if (realK == 0) {
            return data.get(0);
        }
        data.get(size - realK - 1).next = null;
        data.get(size - 1).next = data.get(0);
        return data.get(size - realK);
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        System.out.println(rotateList.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(rotateList.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
    }

}
