import models.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        int middleIndex = 2;
        ListNode middle = head.next;
        int deepest = 3;

        ListNode runnable = head.next.next;
        while (runnable.next != null) {
            runnable = runnable.next;
            deepest++;

            int newMiddleIndex = Math.ceilDiv(deepest, 2);
            if (newMiddleIndex > middleIndex) {
                middleIndex = newMiddleIndex;
                middle = middle.next;
            }
        }

        return deepest % 2 == 0 ? middle.next : middle;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList handler = new MiddleOfTheLinkedList();
        System.out.println(handler.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }

}
