/* vienhuynhemc */
public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    int[] usedSChars = new int[128];
    int[] usedTChars = new int[128];

    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    int n = sChars.length;

    for (int i = 0; i < n; i++) {
      int sChar = sChars[i];
      int tChar = tChars[i];

      if (usedSChars[sChar] == 0) {
        usedSChars[sChar] = tChar;
      } else if (usedSChars[sChar] != tChar) {
        return false;
      }

      if (usedTChars[tChar] == 0) {
        usedTChars[tChar] = sChar;
      } else if (usedTChars[tChar] != sChar) {
        return false;
      }
    }

    return true;
  }
}
