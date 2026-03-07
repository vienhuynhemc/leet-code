/* vienhuynhemc */
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {

  public int minFlips(String s) {
    int minFlipsOfPatternStartWithZero = 0;
    int minFlipsOfPatternStartWithOne = 0;
    int curFlipsOfPatternStartWithZero = 0;
    int curFlipsOfPatternStartWithOne = 0;

    final int length = s.length() * 2;
    for (int i = 0; i < length; i++) {
      final int charIndex = i % s.length();
      final char curChar = s.charAt(charIndex);

      if (i % 2 == 0) {
        if (curChar == '0') curFlipsOfPatternStartWithOne++;
        if (curChar == '1') curFlipsOfPatternStartWithZero++;
      }

      if (i % 2 == 1) {
        if (curChar == '0') curFlipsOfPatternStartWithZero++;
        if (curChar == '1') curFlipsOfPatternStartWithOne++;
      }

      if (i == s.length() - 1) {
        minFlipsOfPatternStartWithZero = curFlipsOfPatternStartWithZero;
        minFlipsOfPatternStartWithOne = curFlipsOfPatternStartWithOne;
      }

      if (i >= s.length()) {
        if (charIndex % 2 == 0) {
          if (curChar == '0') curFlipsOfPatternStartWithOne--;
          if (curChar == '1') curFlipsOfPatternStartWithZero--;
        }

        if (charIndex % 2 == 1) {
          if (curChar == '0') curFlipsOfPatternStartWithZero--;
          if (curChar == '1') curFlipsOfPatternStartWithOne--;
        }

        minFlipsOfPatternStartWithZero = Math.min(minFlipsOfPatternStartWithZero, curFlipsOfPatternStartWithZero);
        minFlipsOfPatternStartWithOne = Math.min(minFlipsOfPatternStartWithOne, curFlipsOfPatternStartWithOne);
      }
    }

    return Math.min(minFlipsOfPatternStartWithZero, minFlipsOfPatternStartWithOne);
  }
}
