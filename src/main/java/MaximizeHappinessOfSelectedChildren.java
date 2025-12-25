/* vienhuynhemc */
import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

  public long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);

    int index = happiness.length - 1;
    int count = 0;
    long result = 0;
    while (count < k) {
      int value = happiness[index--] - count++;
      if (value <= 0) {
        return result;
      }

      result += value;
    }

    return result;
  }
}
