/* vienhuynhemc */
public class ConstructKPalindromeStrings {

  public boolean canConstruct(String s, int k) {
    final char[] chars = s.toCharArray();
    if (chars.length < k) {
      return false;
    }

    int[] count = new int[26];
    for (char aChar : chars) {
      count[aChar - 'a']++;
    }

    int countOdd = 0;
    for (int j : count) {
      if (j % 2 == 1) {
        countOdd++;
      }
    }

    return countOdd <= k;
  }

  public static void main(String[] args) {
    final ConstructKPalindromeStrings test = new ConstructKPalindromeStrings();
    System.out.println(test.canConstruct("annabelle", 2));
    System.out.println(test.canConstruct("leetcode", 2));
    System.out.println(test.canConstruct("true", 4));
  }
}
