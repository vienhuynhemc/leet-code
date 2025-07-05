package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        final Map<Character, List<List<Integer>>> charsWithIndex = new HashMap<>();

        final int m = board.length;
        final int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char aChar = board[i][j];
                final List<List<Integer>> index = charsWithIndex.getOrDefault(aChar, new ArrayList<>());
                index.add(List.of(i, j));

                charsWithIndex.put(aChar, index);
            }
        }

        final char[] wordChars = word.toCharArray();
        return search(wordChars, 0, wordChars.length, charsWithIndex, -1, -1, new boolean[m][n]);
    }

    private boolean search(final char[] wordChars, int wordCharsIndex, int wordCharsLength, final Map<Character, List<List<Integer>>> charsWithIndex, int r, int c, boolean[][] seen) {
        if (wordCharsIndex == wordCharsLength) {
            return true;
        }

        char aChar = wordChars[wordCharsIndex];
        final List<List<Integer>> index = charsWithIndex.get(aChar);
        if (index == null) {
            return false;
        }

        for (List<Integer> integers : index) {
            int curR = integers.get(0);
            int curC = integers.get(1);

            if (!isNextTo(r, c, curR, curC) || seen[curR][curC]) {
                continue;
            }

            seen[curR][curC] = true;
            boolean result = search(wordChars, wordCharsIndex + 1, wordCharsLength, charsWithIndex, curR, curC, seen);
            if (result) {
                return true;
            }
            seen[curR][curC] = false;
        }

        return false;
    }

    private boolean isNextTo(int r, int c, int curR, int curC) {
        if (r == -1 && c == -1) {
            return true;
        }
        return r == curR && (Math.abs(c - curC) == 1) || c == curC && (Math.abs(r - curR) == 1);
    }

}
