import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        final int n = s.length();
        final char[] chars = s.toCharArray();

        final Set<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < n; i++) {
            distinctChars.add(chars[i]);
        }

        int ans = 0;
        for (Character distinctChar : distinctChars) {
            int start = -1;
            int end = -1;

            for (int i = 0; i < chars.length; i++) {
                if (distinctChar != chars[i]) {
                    continue;
                }
                if (start == -1) {
                    start = i;
                    continue;
                }

                end = i;
            }

            if (start == -1 || end == -1) {
                continue;
            }

            final Set<Character> between = new HashSet<>();
            for (int i = start + 1; i < end; i++) {
                between.add(chars[i]);
            }

            ans += between.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        final UniqueLength3PalindromicSubsequences test = new UniqueLength3PalindromicSubsequences();
        System.out.println(test.countPalindromicSubsequence("aabca"));
        System.out.println(test.countPalindromicSubsequence("adc"));
        System.out.println(test.countPalindromicSubsequence("bbcbaba"));
    }

}
