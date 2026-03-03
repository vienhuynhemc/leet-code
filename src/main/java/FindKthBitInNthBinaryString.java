/* vienhuynhemc */
public class FindKthBitInNthBinaryString {

  public char findKthBit(int n, int k) {
    String binaryString = "0";

    while (n-- > 0) binaryString = binaryString + "1" + invertThenReverse(binaryString);

    return binaryString.charAt(k - 1);
  }

  private String invertThenReverse(String s) {
    final StringBuilder result = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) result.append(s.charAt(i) == '1' ? '0' : '1');

    return result.toString();
  }
}
