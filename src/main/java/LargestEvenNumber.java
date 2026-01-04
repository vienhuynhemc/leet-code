/* vienhuynhemc */
public class LargestEvenNumber {

  public String largestEven(String s) {
    int removedIndex = -1;

    final char[] chars = s.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == '2') {
        removedIndex = i + 1;
        break;
      }
    }

    return removedIndex == -1 ? "" : s.substring(0, removedIndex);
  }

  static void main() {
    final LargestEvenNumber l = new LargestEvenNumber();
    System.out.println(l.largestEven("1112"));
    System.out.println(l.largestEven("1111"));
    System.out.println(l.largestEven("111121"));
    System.out.println(l.largestEven("121111"));
    System.out.println(l.largestEven("211111"));
  }
}
