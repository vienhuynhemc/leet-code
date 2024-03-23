import models.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        final ListNode[] nodes = new ListNode[50000];
        int nodesSize = 0;

        while (head != null) {
            nodes[nodesSize++] = head;
            head = head.next;
        }

        boolean isOdd = nodesSize % 2 != 0;

        int mid = nodesSize / 2;
        ListNode preNode = null;
        for (int i = 0; i < mid; i++) {
            ListNode left = nodes[i];
            ListNode right = nodes[--nodesSize];

            left.next = right;

            if (i != 0) {
                preNode.next = left;
            }

            preNode = right;
        }

        if (preNode == null) {
            return;
        }

        if (isOdd) {
            nodes[mid].next = null;
            preNode.next = nodes[mid];
        } else {
            preNode.next = null;
        }
    }

    public static void main(String[] args) {
        ReorderList handler = new ReorderList();
        handler.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

}
