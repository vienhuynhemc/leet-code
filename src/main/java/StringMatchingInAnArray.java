/* vienhuynhemc */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {

  public List<String> stringMatching(String[] words) {
    final Set<String> ans = new HashSet<>();

    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      final int[] lps = buildLPSArray(word);

      for (int j = 0; j < words.length; j++) {
        if (j == i) {
          continue;
        }

        if (isSubString(word, words[j], lps)) {
          ans.add(word);
        }
      }
    }

    return new ArrayList<>(ans);
  }

  private boolean isSubString(String word, String target, int[] lps) {
    final char[] wordChars = word.toCharArray();
    final char[] targetChars = target.toCharArray();

    if (wordChars.length > targetChars.length) {
      return false;
    }

    int start = 0;
    int i = 0;
    while (i < targetChars.length) {
      if (wordChars[start] == targetChars[i]) {
        start++;
        i++;
        if (start == wordChars.length) {
          return true;
        }
      } else {
        if (start == 0) {
          i++;
        } else {
          start = lps[start - 1];
        }
      }
    }

    return false;
  }

  private int[] buildLPSArray(String word) {
    final char[] chars = word.toCharArray();
    final int[] ans = new int[chars.length];
    ans[0] = 0;
    int i = 1;
    int len = 0;
    while (i < chars.length) {
      if (chars[i] == chars[len]) {
        ans[i] = ans[len] + 1;
        len++;
        i++;
      } else if (len != 0) {
        len = ans[len - 1];
      } else {
        ans[i] = 0;
        i++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    final StringMatchingInAnArray test = new StringMatchingInAnArray();
    System.out.println(test.stringMatching(new String[] { "mass", "as", "hero", "superhero" }));
    System.out.println(test.stringMatching(new String[] { "leetcode", "et", "code" }));
    System.out.println(test.stringMatching(new String[] { "blue", "green", "bu" }));
  }
}
