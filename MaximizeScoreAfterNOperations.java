import java.util.ArrayList;
import java.util.List;

public class MaximizeScoreAfterNOperations {

    public int maxScore(int[] nums) {
        int n = nums.length / 2;
        int[] dp = new int[1 << nums.length];
        boolean[] isUnits = new boolean[dp.length];
        for (int i = 0; i != nums.length; i++) {
            for (int j = i + 1; j != nums.length; j++) {
                int key = 1 << i | 1 << j;
                isUnits[key] = true;
                dp[key] = gcd(nums[i], nums[j]);
            }
        }
        List<List<Integer>> groups = initList(n);
        breakCombinations(dp.length, groups);
        for (int i = 2; i <= n; i++) {
            List<Integer> curs = groups.get(i);
            for (int state : curs) {
                for (int mask = state; mask != 0; mask = (mask - 1) & state) {
                    int unit = state ^ mask;
                    if (isUnits[unit]) {
                        dp[state] = Math.max(dp[state], dp[mask] + dp[unit] * i);
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    private void breakCombinations(int size, List<List<Integer>> groups) {
        for (int i = 0; i != size; i++) {
            int bits = Integer.bitCount(i);
            if (bits % 2 == 0) {
                groups.get(bits / 2).add(i);
            }
        }
    }

    private List<List<Integer>> initList(int size) {
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            groups.add(new ArrayList<>());
        }
        return groups;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaximizeScoreAfterNOperations maximizeScoreAfterNOperations = new MaximizeScoreAfterNOperations();
        System.out.println(maximizeScoreAfterNOperations.maxScore(new int[]{1, 2}));
        System.out.println(maximizeScoreAfterNOperations.maxScore(new int[]{3, 4, 6, 8}));
        System.out.println(maximizeScoreAfterNOperations.maxScore(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
