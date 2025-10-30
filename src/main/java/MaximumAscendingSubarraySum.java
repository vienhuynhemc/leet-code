
public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
                continue;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            currentSum = nums[i];
        }

        return Math.max(maxSum, currentSum);
    }

    public static void main(String[] args) {
        final MaximumAscendingSubarraySum tester = new MaximumAscendingSubarraySum();
        System.out.println(tester.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(tester.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(tester.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

}
