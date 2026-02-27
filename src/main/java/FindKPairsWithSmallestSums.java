/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    final Comparator<int[]> comparator = Comparator.comparingInt(n -> nums1[n[0]] + nums2[n[1]]);
    final PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);

    final List<List<Integer>> result = new ArrayList<>();

    final int initialElement = Math.min(nums1.length, k);
    for (int i = 0; i < initialElement; i++) heap.add(new int[] { i, 0 });

    while (!heap.isEmpty() && k > 0) {
      final int[] minimum = heap.poll();

      result.add(List.of(nums1[minimum[0]], nums2[minimum[1]]));
      k--;

      if (minimum[1] < nums2.length - 1) heap.add(new int[] { minimum[0], minimum[1] + 1 });
    }

    return result;
  }
}
