/* vienhuynhemc */
public class ValidWord {

  public boolean isValid(String word) {
    final char[] chars = word.toCharArray();
    if (chars.length < 3) {
      return false;
    }

    boolean hasVowel = false;
    boolean hasConsonant = false;
    for (char c : chars) {
      final boolean isNumberDigit = isNumberDigit(c);
      final boolean isValid = isNumberDigit || isLetterDigit(c);
      if (!isValid) {
        return false;
      }

      if (!hasVowel) {
        hasVowel = isVowel(c);
      }

      if (!hasConsonant) {
        hasConsonant = !isVowel(c) && !isNumberDigit;
      }
    }

    return hasVowel && hasConsonant;
  }

  private boolean isVowel(int decimalValue) {
    return (
      decimalValue == 65 ||
      decimalValue == 69 ||
      decimalValue == 73 ||
      decimalValue == 79 ||
      decimalValue == 85 ||
      decimalValue == 97 ||
      decimalValue == 101 ||
      decimalValue == 105 ||
      decimalValue == 111 ||
      decimalValue == 117
    );
  }

  private boolean isNumberDigit(int decimalValue) {
    return decimalValue > 47 && decimalValue < 58;
  }

  private boolean isLetterDigit(int decimalValue) {
    return (decimalValue > 64 && decimalValue < 91) || (decimalValue > 96 && decimalValue < 123);
  }
}
