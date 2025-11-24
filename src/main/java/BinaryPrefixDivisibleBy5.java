/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

  public List<Boolean> prefixesDivBy5(int[] nums) {
    final List<Boolean> result = new ArrayList<>(nums.length);

    int mod = 0;
    for (int num : nums) {
      mod = (mod * 2 + num) % 5;
      result.add(mod == 0);
    }

    return result;
  }
}
