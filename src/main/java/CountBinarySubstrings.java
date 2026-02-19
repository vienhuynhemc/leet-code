/* vienhuynhemc */
public class CountBinarySubstrings {

  public int countBinarySubstrings(String s) {
    final char[] chars = s.toCharArray();

    int right = 0;
    int left = 0;

    final int[] bitCount = new int[2];
    int previousBit = -1;

    int result = 0;

    while (right < chars.length) {
      final int currentBit = chars[right] == '1' ? 1 : 0;

      if (previousBit == -1 || previousBit == currentBit || bitCount[currentBit] == 0) {
        previousBit = currentBit;
        bitCount[previousBit]++;
        right++;
        continue;
      }

      result += Math.min(bitCount[0], bitCount[1]);
      final int leftBit = chars[left] == '1' ? 1 : 0;
      while (bitCount[leftBit] != 0) {
        bitCount[leftBit]--;
        left++;
      }
    }

    result += Math.min(bitCount[0], bitCount[1]);

    return result;
  }
}
