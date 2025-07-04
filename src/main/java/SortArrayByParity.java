package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                list.add(0, num);
                continue;
            }

            list.add(num);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
