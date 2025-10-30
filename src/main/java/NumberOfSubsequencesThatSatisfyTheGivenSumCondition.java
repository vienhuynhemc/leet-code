
import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    private static final int MOD = (int) (Math.pow(10, 9) + 7);

    public int numSubseq(int[] nums, int target) {
        int[] exps = new int[nums.length];
        exps[0] = 1;
        for (int i = 1; i < exps.length; i++) {
            exps[i] = 2 * exps[i - 1] % MOD;
        }
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        Arrays.sort(nums);
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + exps[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition numberOfSubsequencesThatSatisfyTheGivenSumCondition = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        System.out.println(numberOfSubsequencesThatSatisfyTheGivenSumCondition.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(numberOfSubsequencesThatSatisfyTheGivenSumCondition.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(numberOfSubsequencesThatSatisfyTheGivenSumCondition.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(numberOfSubsequencesThatSatisfyTheGivenSumCondition.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
    }

}
