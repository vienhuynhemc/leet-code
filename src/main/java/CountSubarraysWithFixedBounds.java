
public class CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMinIdx = -1;
        int lastMaxIdx = -1;

        int n = nums.length;

        long count = 0;

        int left = 0;
        int right = 0;
        while (right < n) {
            int num = nums[right];
            if (num < minK || num > maxK) {
                right++;
                left = right;
                continue;
            }

            if (num == minK) {
                lastMinIdx = right;
            }
            if (num == maxK) {
                lastMaxIdx = right;
            }

            if (lastMinIdx >= left && lastMaxIdx >= left) {
                count += Math.min(lastMinIdx, lastMaxIdx) - left + 1;
            }

            right++;
        }


        return count;
    }

}
