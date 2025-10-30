/* vienhuynhemc */
public class AppendCharactersToStringToMakeSubsequence {

  public int appendCharacters(String s, String t) {
    final char[] tChars = t.toCharArray();
    final char[] sChars = s.toCharArray();

    int prefixCount = 0;
    int left = 0;

    for (char tChar : tChars) {
      boolean isFound = false;

      for (int i = left; i < sChars.length; i++) {
        if (sChars[i] == tChar) {
          prefixCount++;
          left = i + 1;

          isFound = true;

          break;
        }
      }

      if (!isFound || left == sChars.length) {
        break;
      }
    }

    return tChars.length - prefixCount;
  }

  public static void main(String[] args) {
    final var handler = new AppendCharactersToStringToMakeSubsequence();
    System.out.println(handler.appendCharacters("coaching", "coding"));
  }
}
