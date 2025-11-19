/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

  public int findFinalValue(int[] nums, int original) {
    final Set<Integer> database = new HashSet<>();

    for (int num : nums) {
      database.add(num);
    }

    while (database.contains(original)) {
      original *= 2;
    }

    return original;
  }
}
