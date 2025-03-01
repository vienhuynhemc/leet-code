import java.util.Arrays;

public class ApplyOperationsToAnArray {

    public int[] applyOperations(int[] nums) {
        final int[] ans = new int[nums.length];

        final int limit = nums.length - 1;
        int i = 0;
        int k = 0;
        while (i < limit) {
            if (nums[i] == 0) {
                i++;
                continue;
            }

            if (nums[i] == nums[i + 1]) {
                ans[k++] = nums[i] * 2;
                nums[i + 1] = 0;
            } else {
                ans[k++] = nums[i];
            }
            i++;
        }

        if (nums[limit] != 0) {
            ans[k] = nums[limit];
        }

        return ans;
    }

    public static void main(String[] args) {
        final ApplyOperationsToAnArray tester = new ApplyOperationsToAnArray();
        System.out.println(Arrays.toString(tester.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(tester.applyOperations(new int[]{0, 1})));
    }

}
