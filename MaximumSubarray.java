public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxCurrentSum = 0;
        int maxSum = 0;
        for (int num : nums) {
            maxCurrentSum += num;
            if (maxCurrentSum > maxSum)
                maxSum = maxCurrentSum;
            if (maxCurrentSum < 0)
                maxCurrentSum = 0;
        }
        if (maxSum == 0) {
            int max = nums[0];
            for (int value : nums)
                if (value > max)
                    max = value;
            maxSum = max;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{1}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

}
