/* vienhuynhemc */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentIDs {

  public long[] mostFrequentIDs(int[] nums, int[] freq) {
    final Heap heap = new Heap();
    final Map<Integer, Node> nodeById = new HashMap<>();
    final long[] result = new long[nums.length];

    for (int i = 0; i < nums.length; i++) {
      final Node curNode = nodeById.get(nums[i]);

      if (curNode == null) {
        final Node newNode = new Node(nums[i], freq[i]);

        nodeById.put(nums[i], newNode);
        heap.put(new Pair(freq[i], newNode));
      } else {
        curNode.freq += freq[i];
        heap.put(new Pair(curNode.freq, curNode));
      }

      while (true) {
        final Pair pair = heap.peek();
        if (pair == null) {
          result[i] = 0;
          break;
        }

        if (pair.freqSnapshot != pair.node.freq) {
          heap.pop();
          continue;
        }

        result[i] = pair.freqSnapshot;
        break;
      }
    }

    return result;
  }

  private static final class Node {

    int id;
    long freq;

    public Node(int id, int freq) {
      this.id = id;
      this.freq = freq;
    }
  }

  private record Pair(long freqSnapshot, Node node) {}

  private static class Heap {

    private final List<Pair> heap;

    public Heap() {
      heap = new ArrayList<>();
    }

    public void put(Pair value) {
      heap.add(value);
      heapifyUp(heap.size() - 1);
    }

    public void pop() {
      heap.set(0, heap.getLast());
      heap.removeLast();

      heapifyDown(0);
    }

    public Pair peek() {
      return heap.isEmpty() ? null : heap.getFirst();
    }

    private void heapifyUp(int i) {
      if (i == 0) {
        return;
      }

      final int parentIndex = (i - 1) / 2;
      if (heap.get(parentIndex).freqSnapshot >= heap.get(i).freqSnapshot) {
        return;
      }

      swap(parentIndex, i);
      heapifyUp(parentIndex);
    }

    private void swap(int i, int j) {
      final Pair tmp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, tmp);
    }

    private void heapifyDown(int i) {
      final int leftIndex = 2 * i + 1;
      if (leftIndex >= heap.size()) {
        return;
      }

      final int rightIndex = leftIndex + 1;
      int index = leftIndex;

      if (rightIndex < heap.size() && heap.get(rightIndex).freqSnapshot > heap.get(index).freqSnapshot) {
        index = rightIndex;
      }

      if (heap.get(index).freqSnapshot <= heap.get(i).freqSnapshot) {
        return;
      }

      swap(i, index);
      heapifyDown(index);
    }
  }
}
