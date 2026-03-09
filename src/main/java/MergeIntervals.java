/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    final List<int[]> storage = new ArrayList<>();

    int index = 1;
    int startInterval = intervals[0][0];
    int endInterval = intervals[0][1];
    while (index < intervals.length) {
      if (intervals[index][0] <= endInterval) endInterval = Math.max(endInterval, intervals[index][1]);
      else {
        storage.add(new int[] { startInterval, endInterval });
        startInterval = intervals[index][0];
        endInterval = intervals[index][1];
      }

      index++;
    }

    storage.add(new int[] { startInterval, endInterval });

    final int[][] result = new int[storage.size()][];
    for (int j = 0; j < result.length; j++) result[j] = storage.get(j);

    return result;
  }

  static void main() {
    final MergeIntervals service = new MergeIntervals();
    System.out.println(Arrays.deepToString(service.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
    System.out.println(Arrays.deepToString(service.merge(new int[][] { { 1, 4 }, { 4, 5 } })));
    System.out.println(Arrays.deepToString(service.merge(new int[][] { { 1, 4 }, { 0, 4 } })));
    System.out.println(Arrays.deepToString(service.merge(new int[][] { { 1, 4 }, { 2, 3 } })));
  }
}
