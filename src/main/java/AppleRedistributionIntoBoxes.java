/* vienhuynhemc */
import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

  public int minimumBoxes(int[] apple, int[] capacity) {
    int numsOfApple = 0;
    for (int i : apple) {
      numsOfApple += i;
    }

    Arrays.sort(capacity);
    for (int i = capacity.length - 1; i >= 0; i--) {
      numsOfApple -= capacity[i];
      if (numsOfApple <= 0) {
        return capacity.length - i;
      }
    }

    return capacity.length;
  }
}
