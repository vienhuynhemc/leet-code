package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;
        int n = length - 2;

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Add fist number
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);

            int remain = -nums[i];
            // Two pointer
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == remain) {
                    // Add remain two number
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    // Add triplet into triplets
                    triplets.add(triplet);

                    // Reset triplet to prepare for next triplet
                    triplet = new ArrayList<>();
                    triplet.add(nums[i]);

                    int leftVal = nums[left];
                    left++;
                    while (left < right && nums[left] == leftVal) {
                        left++;
                    }
                } else if (sum > remain) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum.threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum.threeSum(new int[]{0, 0, 0}));
    }


}
