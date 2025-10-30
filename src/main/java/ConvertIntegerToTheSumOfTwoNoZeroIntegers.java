/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

  final Set<Integer> cache = new HashSet<>();

  public int[] getNoZeroIntegers(int n) {
    final int[] res = new int[2];

    for (int i = 1; i < n; i++) {
      final boolean isNonZeroInteger = isNonZeroInteger(i);
      if (!isNonZeroInteger) {
        continue;
      }

      cache.add(i);

      final int remain = n - i;
      if (cache.contains(remain)) {
        res[0] = i;
        res[1] = remain;
        break;
      }
    }

    return res;
  }

  private boolean isNonZeroInteger(int n) {
    while (n > 9) {
      if (n % 10 == 0) {
        return false;
      }
      n /= 10;
    }

    return true;
  }
}
