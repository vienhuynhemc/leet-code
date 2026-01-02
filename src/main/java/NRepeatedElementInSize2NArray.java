/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2NArray {

  public int repeatedNTimes(int[] nums) {
    final Set<Integer> seen = new HashSet<>();

    for (int num : nums) {
      if (seen.contains(num)) {
        return num;
      }

      seen.add(num);
    }

    return 0;
  }
}
