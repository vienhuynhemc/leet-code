/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisibleByK {

  public int smallestRepunitDivByK(int k) {
    final Set<Integer> database = new HashSet<>();

    int mod = 1 % k;
    int length = 1;

    if (mod == 0) {
      return length;
    }

    database.add(mod);

    while (true) {
      mod = (mod * 10 + 1) % k;
      length++;

      if (mod == 0) {
        return length;
      }

      if (database.contains(mod)) {
        return -1;
      }

      database.add(mod);
    }
  }
}
