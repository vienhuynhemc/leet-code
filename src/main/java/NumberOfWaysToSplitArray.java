public class NumberOfWaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        long[] suffixSums = new long[nums.length];
        suffixSums[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            suffixSums[i] = nums[i] + suffixSums[i + 1];
        }

        long[] prefixSums = new long[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSums[i] = nums[i];
            if (i > 0) {
                prefixSums[i] += prefixSums[i - 1];
            }

            if (prefixSums[i] >= suffixSums[i + 1]) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        final NumberOfWaysToSplitArray test = new NumberOfWaysToSplitArray();
        System.out.println(test.waysToSplitArray(new int[]{10, 4, -8, 7}));
        System.out.println(test.waysToSplitArray(new int[]{2, 3, 1, 0}));
    }

}
