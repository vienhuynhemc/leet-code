public class ShortestSubarrayWithORAtLeastKI {

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int total = 0;
        int minimumSubarrayLength = Integer.MAX_VALUE;

        while (right < n) {
            total |= nums[right];

            if (total >= k) {

                int newLength = right - left + 1;
                if (newLength < minimumSubarrayLength) {
                    minimumSubarrayLength = newLength;
                }

                // reset
                left++;
                right = left;
                total = 0;
                continue;
            }

            right++;
        }


        return minimumSubarrayLength == Integer.MAX_VALUE ? -1 : minimumSubarrayLength;
    }

}
