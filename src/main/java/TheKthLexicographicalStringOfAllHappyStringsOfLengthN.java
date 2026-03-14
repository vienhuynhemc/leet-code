/* vienhuynhemc */
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

  public String getHappyString(int n, int k) {
    final int numberOfHappyStrings = 3 * (int) Math.pow(2, n - 1);
    if (k > numberOfHappyStrings) return "";

    final StringBuilder happyStringBuilder = new StringBuilder();
    final char[] allowChars = new char[] { 'a', 'b', 'c' };

    Character prevChar = null;

    for (int i = 0; i < numberOfHappyStrings; i++) {
      for (char allowChar : allowChars) {
        if (prevChar != null && allowChar == prevChar) continue;

        final int numberOfBlocks = (int) Math.pow(2, n - i - 1);

        if (k > numberOfBlocks) {
          k -= numberOfBlocks;
          continue;
        }

        happyStringBuilder.append(allowChar);
        prevChar = allowChar;
        break;
      }
    }

    return happyStringBuilder.toString();
  }

  static void main() {
    final var tester = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN();
    System.out.println(tester.getHappyString(1, 3));
    System.out.println(tester.getHappyString(1, 4));
    System.out.println(tester.getHappyString(3, 9));
  }
}
