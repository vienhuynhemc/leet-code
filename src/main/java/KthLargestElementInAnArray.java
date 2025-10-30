
import java.util.PriorityQueue;

import static java.lang.System.out;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return !priorityQueue.isEmpty() ? priorityQueue.poll() : -1;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray service = new KthLargestElementInAnArray();
        out.println(service.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        out.println(service.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
