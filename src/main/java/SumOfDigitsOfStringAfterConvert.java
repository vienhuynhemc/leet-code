package src.main.java;

public class SumOfDigitsOfStringAfterConvert {

    public int getLucky(String s, int k) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value += this.splitAndMerge(s.charAt(i) - 96);
        }
        for (int i = 1; i < k; i++) {
            value = this.splitAndMerge(value);
        }
        return value;
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
        SumOfDigitsOfStringAfterConvert sumOfDigitsOfStringAfterConvert = new SumOfDigitsOfStringAfterConvert();
        System.out.println(sumOfDigitsOfStringAfterConvert.getLucky("iiii", 1));
        System.out.println(sumOfDigitsOfStringAfterConvert.getLucky("leetcode", 2));
        System.out.println(sumOfDigitsOfStringAfterConvert.getLucky("zbax", 2));
    }

}
