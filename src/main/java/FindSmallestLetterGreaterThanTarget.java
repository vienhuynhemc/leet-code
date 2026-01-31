/* vienhuynhemc */
public class FindSmallestLetterGreaterThanTarget {

  public char nextGreatestLetter(char[] letters, char target) {
    char result = letters[0];
    int minGap = 25;

    for (char letter : letters) {
      int gap = letter - target;
      if (gap > 0 && gap < minGap) {
        minGap = gap;
        result = letter;
      }
    }

    return result;
  }

  static void main() {
    final var tester = new FindSmallestLetterGreaterThanTarget();
    System.out.println(tester.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
  }
}
