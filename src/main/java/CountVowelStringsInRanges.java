package src.main.java;

import java.util.Arrays;
import java.util.Set;

public class CountVowelStringsInRanges {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries) {
        final int[] dp = new int[words.length];
        int vowelCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowelStrings(words[i])) {
                vowelCount++;
            }
            dp[i] = vowelCount;
        }

        final int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] - 1;
            if (left < 0) {
                ans[i] = dp[queries[i][1]];
            } else {
                ans[i] = dp[queries[i][1]] - dp[left];
            }
        }
        return ans;
    }

    private boolean isVowelStrings(String word) {
        return VOWELS.contains(word.charAt(0)) && VOWELS.contains(word.charAt(word.length() - 1));
    }

    public static void main(String[] args) {
        CountVowelStringsInRanges test = new CountVowelStringsInRanges();

        String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = new int[][]{{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(test.vowelStrings(words, queries)));

        words = new String[]{"a", "e", "i"};
        queries = new int[][]{{0, 2}, {0, 1}, {2, 2}};
        System.out.println(Arrays.toString(test.vowelStrings(words, queries)));
    }

}
