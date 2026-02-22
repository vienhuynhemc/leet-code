/* vienhuynhemc */
public class BinaryGap {

  public int binaryGap(int n) {
    int result = 0;

    int left = -1;
    int index = -1;

    while (n > 0) {
      index++;

      final int bit = n % 2;
      n /= 2;

      if (bit != 1) continue;

      if (left == -1) {
        left = index;
        continue;
      }

      result = Math.max(result, index - left);
      left = index;
    }

    return result;
  }
}
