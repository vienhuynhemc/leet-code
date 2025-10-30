import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int numberOfIncrement = 0;

        int current = -1;
        for (int num : nums) {
            if (num > current) {
                current = num;
            } else {
                current++;
                numberOfIncrement += current - num;
            }
        }

        return numberOfIncrement;
    }

}
