package src.main.java;

import src.main.java.model.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        swapPairs(head, head.next);
        return head;
    }

    private void swapPairs(ListNode first, ListNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        if (second.next == null || second.next.next == null) {
            return;
        }
        swapPairs(second.next, second.next.next);
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        System.out.println(swapNodesInPairs.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
    }

}
