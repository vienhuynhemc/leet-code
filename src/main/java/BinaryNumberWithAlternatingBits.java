/* vienhuynhemc */
public class BinaryNumberWithAlternatingBits {

  public boolean hasAlternatingBits(int n) {
    int previousBit = n % 2;
    n /= 2;

    while (n > 0) {
      final int currentBit = n % 2;
      if (previousBit == currentBit) return false;

      previousBit = currentBit;
      n /= 2;
    }

    return true;
  }
}
