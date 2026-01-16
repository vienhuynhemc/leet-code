/* vienhuynhemc */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumSquareAreaByRemovingFencesFromAField {

  private static final int MOD = 1000000007;

  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    hFences = cloneWithAttach2EdgeAndSort(hFences, m);
    vFences = cloneWithAttach2EdgeAndSort(vFences, n);

    final Set<Integer> allDistances = getAllDistances(hFences);
    final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < vFences.length - 1; i++) {
      for (int j = i + 1; j < vFences.length; j++) {
        pq.add(vFences[j] - vFences[i]);
      }
    }
    while (!pq.isEmpty()) {
      final int distance = pq.poll();
      if (allDistances.contains(distance)) {
        return (int) (((long) distance * distance) % MOD);
      }
    }

    return -1;
  }

  private Set<Integer> getAllDistances(int[] data) {
    final Set<Integer> distances = new HashSet<>();

    for (int i = 0; i < data.length - 1; i++) {
      for (int j = i + 1; j < data.length; j++) {
        distances.add(data[j] - data[i]);
      }
    }

    return distances;
  }

  private int[] cloneWithAttach2EdgeAndSort(int[] data, int right) {
    final int[] result = new int[data.length + 2];

    result[0] = 1;
    result[result.length - 1] = right;

    System.arraycopy(data, 0, result, 1, data.length);
    Arrays.sort(result);

    return result;
  }
}
