package src.main.java;

import java.util.Arrays;

public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int previousValue = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i] + previousValue;
            previousValue = result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        RunningSumOf1dArray runningSumOf1dArray = new RunningSumOf1dArray();
        System.out.println(Arrays.toString(runningSumOf1dArray.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSumOf1dArray.runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSumOf1dArray.runningSum(new int[]{3, 1, 2, 10, 1})));
    }

}
