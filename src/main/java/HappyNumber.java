package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        List<Integer> array = new ArrayList<>();
        while (n > 0) {
            array.add(n % 10);
            n /= 10;
        }
        if (array.size() == 1) {
            return array.get(0) == 1;
        }
        return this.isHappy(array.stream().mapToInt(value -> value * value).sum());
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
    }

}
