package src.main.java;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public int[] minOperations(String boxes) {
        final char[] chars = boxes.toCharArray();

        final int[] leftMoves = new int[chars.length];
        int preCount = 0;
        int moves = 0;
        for (int i = 0; i < chars.length; i++) {
            moves += preCount;
            leftMoves[i] = moves;
            if (chars[i] == '1') {
                preCount++;
            }
        }

        final int[] rightMoves = new int[chars.length];
        preCount = 0;
        moves = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            moves += preCount;
            rightMoves[i] = moves;
            if (chars[i] == '1') {
                preCount++;
            }
        }

        final int[] ans = new int[chars.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = leftMoves[i] + rightMoves[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        final MinimumNumberOfOperationsToMoveAllBallsToEachBox test = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
        System.out.println(Arrays.toString(test.minOperations("110")));
        System.out.println(Arrays.toString(test.minOperations("001011")));
    }

}
