package src.main.java;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int maxIncreasing = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                if (count > maxIncreasing) {
                    maxIncreasing = count;
                }
            } else {
                count = 1;
            }
        }

        int maxDecreasing = 1;
        count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > maxDecreasing) {
                    maxDecreasing = count;
                }
            } else {
                count = 1;
            }
        }

        return Math.max(maxIncreasing, maxDecreasing);
    }

}
