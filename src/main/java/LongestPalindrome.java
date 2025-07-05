package src.main.java;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        // From 65 -> 122
        final int[] tracking = new int[58];

        char[] sChar = s.toCharArray();

        for (char c : sChar) {
            tracking[c - 'A']++;
        }

        int longestPalindromeLength = 0;
        boolean hasRemain = false;

        for (int i : tracking) {
            if (i % 2 == 0) {
                longestPalindromeLength += i;
            } else {
                longestPalindromeLength += i - 1;
                if (!hasRemain) {
                    hasRemain = true;
                }
            }
        }

        return hasRemain ? longestPalindromeLength + 1 : longestPalindromeLength;
    }

    public static void main(String[] args) {
        final LongestPalindrome handler = new LongestPalindrome();
        System.out.println(handler.longestPalindrome("ABabAAAbACSfsdfknkfsjnfAKJFKASJD"));
    }

}
