package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        int n = nums.length;

        int left = -1;
        int right = 0;

        int maxSubarrayLength = 0;

        while (right < n) {
            int num = nums[right];
            int count = counts.getOrDefault(num, 0) + 1;

            if (count > k) {
                while (nums[++left] != num) {
                    int numAtLeft = nums[left];
                    counts.put(numAtLeft, counts.get(numAtLeft) - 1);
                }
            } else {
                counts.put(num, count);

                int newLength = right - left;
                if (newLength > maxSubarrayLength) {
                    maxSubarrayLength = newLength;
                }
            }

            right++;
        }

        return maxSubarrayLength;
    }

    public static void main(String[] args) {
        var handler = new LengthOfLongestSubarrayWithAtMostKFrequency();
        System.out.println(handler.maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1));
    }

}
