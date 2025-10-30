
import src.main.java.model.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length == 0) {
            return result;
        }
        boolean[] checks = new boolean[lists.length];
        ListNode[] data = new ListNode[lists.length];
        int minValueIndex = -1;
        int minValue = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                checks[i] = true;
                continue;
            }
            if (minValueIndex == -1 || node.val < minValue) {
                minValueIndex = i;
                minValue = node.val;
            }
            data[i] = node;
        }
        if (minValueIndex == -1) {
            return result;
        }
        data[minValueIndex] = data[minValueIndex].next;
        result = new ListNode(minValue);
        ListNode copy = result;
        while (true) {
            minValueIndex = -1;
            minValue = 0;
            for (int i = 0; i < lists.length; i++) {
                if (checks[i]) {
                    continue;
                }
                ListNode node = data[i];
                if (node == null) {
                    checks[i] = true;
                    continue;
                }
                if (minValueIndex == -1 || node.val < minValue) {
                    minValueIndex = i;
                    minValue = node.val;
                }
            }
            if (minValueIndex == -1) {
                break;
            }
            result.next = new ListNode(minValue);
            result = result.next;
            data[minValueIndex] = data[minValueIndex].next;
        }
        return copy;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        System.out.println(mergeKSortedLists.mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))}));
        System.out.println(mergeKSortedLists.mergeKLists(new ListNode[]{new ListNode(1), new ListNode(0)}));
    }

}
