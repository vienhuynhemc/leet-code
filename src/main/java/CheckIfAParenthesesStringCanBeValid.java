package src.main.java;

import java.util.Stack;

public class CheckIfAParenthesesStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }

        final Stack<Integer> openIndex = new Stack<>();
        final Stack<Integer> dynamicIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                dynamicIndex.push(i);
                continue;
            }

            if (s.charAt(i) == '(') {
                openIndex.push(i);
                continue;
            }

            if (!openIndex.empty()) {
                openIndex.pop();
                continue;
            }

            if (!dynamicIndex.empty()) {
                dynamicIndex.pop();
                continue;
            }

            return false;
        }

        while (!openIndex.empty()) {
            if (dynamicIndex.empty()) {
                break;
            }

            if (dynamicIndex.peek() < openIndex.peek()) {
                return false;
            }

            dynamicIndex.pop();
            openIndex.pop();
        }

        return openIndex.empty();
    }

    public static void main(String[] args) {
        final CheckIfAParenthesesStringCanBeValid test = new CheckIfAParenthesesStringCanBeValid();
        System.out.println(test.canBeValid("(()))()))(()((()()(((()))()()()()()())))()()(()())()(()((()()((()((((((()(()()(()()())(((((())((()))))()(((((((()()())()))())((((((()(())())()((())()()((())((((())(((())(())()()))(((()()())())))((()))))()()()((()))())(())(((()()((())(())(())())()((()))())(())()(()())((((()(((())((()()())(((()(((((()))()))))))(()((())())(())))))(())(((())()()(()))())())))(((())))()()))()())))))())()(()()))(())(()())))())()))((((())(()))()(((())())(()(()))()))((()(())()()))))())(()(((((()", "110001111001011100000100011110101000100110010010011001110010111111100111000100000000101111101001111111011101001110011001001100100001100000000010100010101101100000100001000110111000111110110010111011010010100011111101110011100010010001111001010001001000111101101111111011001000100111100110101000100011011001001100110011111111111100101000100111111100000100101101000101111101000011110001001011111010011010000100100000000011101011001110000110011000100001110101100101111111110100"));

    }

}
