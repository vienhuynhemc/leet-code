
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int minVar = 0;
        for (int i = digits.length - 1; i > -1; i--) {
            int value = digits[i] + minVar;
            if (i == digits.length - 1)
                value++;
            if (value > 9) {
                minVar = 1;
                value -= 10;
            } else
                minVar = 0;
            result.add(0, value);
        }
        if (minVar > 0)
            result.add(0, minVar);
        return result.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9})));
    }

}
