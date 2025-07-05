package src.main.java;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    public int minOperations(int[] nums) {
        int numOfOperations = 0;

        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] == 1) {
                i++;
                continue;
            }

            nums[i] = Math.abs(nums[i] - 1);
            nums[i + 1] = Math.abs(nums[i + 1] - 1);
            nums[i + 2] = Math.abs(nums[i + 2] - 1);

            numOfOperations++;

            if (nums[i + 1] == 0) {
                i += 1;
                continue;
            }

            if (nums[i + 2] == 0) {
                i += 2;
                continue;
            }

            i += 3;
        }

        for (int j = i; j < nums.length; j++) {
            if (nums[j] == 0) {
                return -1;
            }
        }

        return numOfOperations;
    }

}
