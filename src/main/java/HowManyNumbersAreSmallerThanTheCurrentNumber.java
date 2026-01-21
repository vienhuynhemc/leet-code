/* vienhuynhemc */
import java.util.Arrays;
import java.util.Comparator;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

  private record Pair(int value, int index, int result) {}

  public int[] smallerNumbersThanCurrent(int[] nums) {
    final Pair[] pairs = new Pair[nums.length];
    for (int i = 0; i < nums.length; i++) {
      pairs[i] = new Pair(nums[i], i, 0);
    }
    Arrays.sort(pairs, Comparator.comparingInt(Pair::value));

    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i].value > pairs[i - 1].value) {
        pairs[i] = new Pair(pairs[i].value, pairs[i].index, i);
      } else if (pairs[i].value == pairs[i - 1].value) {
        pairs[i] = new Pair(pairs[i].value, pairs[i].index, pairs[i - 1].result);
      }
    }

    final int[] result = new int[nums.length];
    for (Pair pair : pairs) {
      result[pair.index] = pair.result;
    }

    return result;
  }
}
