/* vienhuynhemc */
import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {

  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);

    final int diff = arr[1] - arr[0];
    for (int i = 2; i < arr.length; i++) if (arr[i] - arr[i - 1] != diff) return false;

    return true;
  }
}
