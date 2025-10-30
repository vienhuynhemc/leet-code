
import src.main.java.model.ListNode;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;

        ListNode prevNodeAtAIndex = list1;
        while (++index != a) {
            prevNodeAtAIndex = prevNodeAtAIndex.next;
        }

        ListNode nextNodeAtBIndex = prevNodeAtAIndex.next;
        while (index++ != b) {
            nextNodeAtBIndex = nextNodeAtBIndex.next;
        }

        prevNodeAtAIndex.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = nextNodeAtBIndex.next;

        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists handler = new MergeInBetweenLinkedLists();
        ListNode list1 = new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(6, new ListNode(9, new ListNode(5))))));
        ListNode list2 = new ListNode(100000, new ListNode(1000001, new ListNode(1000002)));
        System.out.println(handler.mergeInBetween(list1, 3, 4, list2));
    }

}
