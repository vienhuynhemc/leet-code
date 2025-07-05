package src.main.java;

public class CountIntegersWithEvenDigitSum {

    public int countEven(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (splitAndMerge(i) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private int splitAndMerge(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        CountIntegersWithEvenDigitSum countIntegersWithEvenDigitSum = new CountIntegersWithEvenDigitSum();
        System.out.println(countIntegersWithEvenDigitSum.countEven(4));
        System.out.println(countIntegersWithEvenDigitSum.countEven(30));
    }

}
