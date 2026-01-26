/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);

    int minAbsDiff = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      final int absDiff = Math.abs(arr[i] - arr[i - 1]);
      minAbsDiff = Math.min(minAbsDiff, absDiff);
    }

    final List<List<Integer>> result = new ArrayList<>();
    int left = 0;
    int right = 1;

    while (right < arr.length) {
      if (left == right) {
        right++;
        continue;
      }

      final int diff = arr[right] - arr[left];

      if (diff < minAbsDiff) {
        right++;
        continue;
      }
      if (diff > minAbsDiff) {
        left++;
        continue;
      }

      result.add(List.of(arr[left++], arr[right++]));
    }

    return result;
  }
}
