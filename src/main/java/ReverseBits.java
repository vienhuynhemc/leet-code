/* vienhuynhemc */
public class ReverseBits {

  public int reverseBits(int n) {
    final StringBuilder reverseBitsBuilder = new StringBuilder();

    while (n > 0) {
      reverseBitsBuilder.append(n % 2);
      n /= 2;
    }
    while (reverseBitsBuilder.length() < 32) reverseBitsBuilder.append("0");

    final char[] reverseBits = reverseBitsBuilder.toString().toCharArray();
    int result = 0;

    for (int i = reverseBits.length - 1; i >= 0; i--) {
      if (reverseBits[i] == '0') continue;
      result += (int) Math.pow(2, reverseBits.length - i - 1);
    }

    return result;
  }
}
