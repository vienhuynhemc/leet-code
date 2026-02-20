/* vienhuynhemc */
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    final PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
    for (int stone : stones) pq.offer(stone);

    while (pq.size() > 1) {
      final Integer heaviest = pq.poll();
      final Integer secondHeaviest = pq.poll();

      final int newStone = heaviest - secondHeaviest;
      if (newStone > 0) pq.offer(newStone);
    }

    return pq.isEmpty() ? 0 : pq.peek();
  }
}
