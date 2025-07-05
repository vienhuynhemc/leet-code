package src.main.java;

import java.util.HashMap;

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxCount = 1;
        int total = 0;

        for (int num : nums) {
            if (!dp.containsKey(num)) {
                dp.put(num, 1);

                if (maxCount == 1) {
                    total++;
                }
            } else {
                int newCount = dp.get(num) + 1;
                if (newCount > maxCount) {
                    maxCount = newCount;
                    total = newCount;
                } else if (newCount == maxCount) {
                    total += newCount;
                }
                dp.put(num, newCount);
            }
        }

        return total;
    }

}
