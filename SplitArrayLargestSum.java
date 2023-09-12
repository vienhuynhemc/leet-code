public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
            if (num > left) {
                left = num;
            }
        }

        int mid;
        int result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (canSplit(nums, mid, k)) {
                result = mid;
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }

        return result;
    }

    private boolean canSplit(int[] nums, int mid, int k) {
        int currentSum = 0;
        int subArray = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > mid) {
                subArray++;
                currentSum = num;
            }
        }
        return subArray + 1 <= k;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArrayLargestSum.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(splitArrayLargestSum.splitArray(new int[]{7, 2, 5, 10, 18}, 3));
        System.out.println(splitArrayLargestSum.splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5));
    }

}
