/* vienhuynhemc */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FindXSumOfAllKLongSubarraysI {

  public int[] findXSum(int[] nums, int k, int x) {
    final HashMap<Integer, Integer> countMap = new HashMap<>();
    int sum = 0;

    for (int i = 0; i < k; i++) {
      final int count = countMap.getOrDefault(nums[i], 0) + 1;
      countMap.put(nums[i], count);
      sum += nums[i];
    }

    final Comparator<Entry<Integer, Integer>> comparator = Comparator.comparingInt(
      Entry<Integer, Integer>::getValue
    ).thenComparingInt(Entry::getKey);
    final PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);
    syncData(pq, countMap, x);

    final int[] result = new int[nums.length - k + 1];
    result[0] = calculateXSum(pq, sum, x);

    int index = 1;
    int prev = nums[index - 1];
    for (int i = k; i < nums.length; i++) {
      sum -= prev;
      sum += nums[i];

      if (countMap.containsKey(prev)) {
        final int prevCount = countMap.get(prev) - 1;
        if (prevCount == 0) {
          countMap.remove(prev);
        } else {
          countMap.put(prev, prevCount);
        }
      }

      prev = nums[index];

      final int count = countMap.getOrDefault(nums[i], 0) + 1;
      countMap.put(nums[i], count);
      syncData(pq, countMap, x);

      result[index++] = calculateXSum(pq, sum, x);
    }

    return result;
  }

  private int calculateXSum(PriorityQueue<Entry<Integer, Integer>> pq, int fallback, int x) {
    if (pq.size() < x) {
      return fallback;
    }

    int result = 0;
    for (Entry<Integer, Integer> entry : pq) {
      result += entry.getKey() * entry.getValue();
    }

    return result;
  }

  private void syncData(PriorityQueue<Entry<Integer, Integer>> pq, HashMap<Integer, Integer> countMap, int x) {
    pq.clear();

    for (Entry<Integer, Integer> entry : countMap.entrySet()) {
      pq.offer(entry);

      if (pq.size() > x) {
        pq.poll();
      }
    }
  }

  static void main() {
    final var handler = new FindXSumOfAllKLongSubarraysI();
    System.out.println(Arrays.toString(handler.findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2)));
  }
}
