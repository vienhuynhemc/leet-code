/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {

  public int maximumLengthSubstring(String s) {
    char[] chs = s.toCharArray();
    int n = s.length();

    Map<Character, Integer> counts = new HashMap<>();

    int longest = 0;
    int idx = 0;

    for (int i = 0; i < n; i++) {
      counts.put(chs[i], counts.getOrDefault(chs[i], 0) + 1);

      if (counts.get(chs[i]) == 3) {
        longest = Math.max(longest, i - idx);

        while (chs[idx] != chs[i]) {
          counts.put(chs[idx], counts.get(chs[idx]) - 1);
          idx++;
        }

        counts.put(chs[idx], counts.get(chs[idx]) - 1);
        idx++;
      } else {
        longest = Math.max(longest, i - idx + 1);
      }
    }
    return longest;
  }

  public static void main(String[] args) {
    MaximumLengthSubstringWithTwoOccurrences handler = new MaximumLengthSubstringWithTwoOccurrences();
    System.out.println(handler.maximumLengthSubstring("bcbbbcba"));
    System.out.println(handler.maximumLengthSubstring("acedc"));
    System.out.println(handler.maximumLengthSubstring("aaaa"));
  }
}
