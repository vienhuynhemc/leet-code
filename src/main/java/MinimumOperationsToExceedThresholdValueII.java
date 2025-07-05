package src.main.java;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {

    public int minOperations(int[] nums, int k) {
        final PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer((long) nums[i]);
        }

        long firstValue = pq.poll();
        int ans = 0;
        while (firstValue < k) {
            final long secondValue = pq.poll();
            final long generatedValue = Math.min(firstValue, secondValue) * 2 + Math.max(firstValue, secondValue);
            pq.offer(generatedValue);

            firstValue = pq.poll();
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        final var tester = new MinimumOperationsToExceedThresholdValueII();
        System.out.println(tester.minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(tester.minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }

}
