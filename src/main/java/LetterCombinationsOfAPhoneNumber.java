/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

  private static final Map<Character, List<String>> LETTERS = Map.of(
    '2',
    List.of("a", "b", "c"),
    '3',
    List.of("d", "e", "f"),
    '4',
    List.of("g", "h", "i"),
    '5',
    List.of("j", "k", "l"),
    '6',
    List.of("m", "n", "o"),
    '7',
    List.of("p", "q", "r", "s"),
    '8',
    List.of("t", "u", "v"),
    '9',
    List.of("w", "x", "y", "z")
  );

  public List<String> letterCombinations(String digits) {
    final List<String> result = new ArrayList<>();
    if (digits.isEmpty()) {
      return result;
    }
    letterCombinations(digits, result, "", 0, digits.length() - 1);
    return result;
  }

  private void letterCombinations(String digits, List<String> result, String current, int currentIndex, int max) {
    final List<String> chars = LETTERS.get(digits.charAt(currentIndex));
    if (currentIndex == max) {
      for (final String string : chars) {
        result.add(current + string);
      }
      return;
    }
    for (final String string : chars) {
      letterCombinations(digits, result, current + string, currentIndex + 1, max);
    }
  }

  public static void main(String[] args) {
    LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
    System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
    System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(""));
    System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("2"));
  }
}
