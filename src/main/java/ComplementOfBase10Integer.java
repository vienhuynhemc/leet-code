/* vienhuynhemc */
public class ComplementOfBase10Integer {

  public int bitwiseComplement(int n) {
    if (n == 0) return 1;

    int result = 0;

    int pow = 1;
    while (n > 0) {
      result += n % 2 == 0 ? pow : 0;

      pow *= 2;
      n /= 2;
    }

    return result;
  }
}
