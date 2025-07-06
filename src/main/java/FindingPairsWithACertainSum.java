package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithACertainSum {

    static class FindSumPairs {

        private final int[] nums1;
        private final int[] nums2;
        private final Map<Integer, Integer> database = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;

            for (int i : nums2) {
                final int count = database.getOrDefault(i, 0) + 1;
                database.put(i, count);
            }
        }

        public void add(int index, int val) {
            final int previousVal = nums2[index];
            database.put(previousVal, database.get(previousVal) - 1);

            final int newVal = previousVal + val;
            nums2[index] = newVal;

            final int countOfNewVal = database.getOrDefault(newVal, 0) + 1;
            database.put(newVal, countOfNewVal);
        }

        public int count(int tot) {
            int result = 0;

            for (int i : nums1) {
                int remainValue = tot - i;
                result += database.getOrDefault(remainValue, 0);
            }

            return result;
        }
    }

}
