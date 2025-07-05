package src.main.java;

import static java.lang.System.out;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int k = 1;
        int remain = 0;
        while (true) {
            Character charOfA = null;
            if (a.length() - k >= 0) {
                charOfA = a.charAt(a.length() - k);
            }

            Character charOfB = null;
            if (b.length() - k >= 0) {
                charOfB = b.charAt(b.length() - k);
            }

            if (charOfA == null && charOfB == null) {
                break;
            }

            int result = plusTwoChar(charOfA, charOfB, remain);
            if (result > 1) {
                result = result % 2;
                remain = 1;
            } else {
                remain = 0;
            }

            builder.insert(0, result);
            k++;
        }

        if (remain != 0) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    private int plusTwoChar(Character charOfA, Character charOfB, int remain) {
        int a = charOfA == null || charOfA == '0' ? 0 : 1;
        int b = charOfB == null || charOfB == '0' ? 0 : 1;
        return a + b + remain;
    }

    public static void main(String[] args) {
        AddBinary service = new AddBinary();
        out.println(service.addBinary("11", "1"));
        out.println(service.addBinary("1010", "1011"));
        out.println(service.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

}
