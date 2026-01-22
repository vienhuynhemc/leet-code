/* vienhuynhemc */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPairRemovalToSortArrayII {

  private static class Node {

    int index;
    long val;
    Node next;
    Node prev;
    boolean isDeleted;

    public Node(int index, int val) {
      this.val = val;
      this.index = index;
    }
  }

  private record Pair(long sum, Node left) {}

  public int minimumPairRemoval(int[] nums) {
    final Node[] nodes = buildDoublyLinkedList(nums);
    final PriorityQueue<Pair> heap = buildHeap(nodes);

    int bad = countNumberOfViolations(nums);
    int ops = 0;
    while (bad != 0) {
      final Pair curPair = heap.poll();

      final Node first = curPair.left;
      final Node second = first.next;
      if (first.isDeleted || second == null || second.isDeleted || first.val + second.val != curPair.sum) {
        continue;
      }

      final Node left = first.prev;
      final Node right = second.next;

      if (first.val > second.val) bad--;
      if (left != null && left.val > first.val) bad--;
      if (right != null && second.val > right.val) bad--;

      first.val = first.val + second.val;
      first.next = right;
      second.isDeleted = true;
      if (right != null) right.prev = first;

      if (left != null && left.val > first.val) bad++;
      if (right != null && first.val > right.val) bad++;

      if (left != null) heap.add(new Pair(first.val + left.val, left));
      if (right != null) heap.add(new Pair(first.val + right.val, first));

      ops++;
    }

    return ops;
  }

  private int countNumberOfViolations(int[] nums) {
    int count = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) count++;
    }

    return count;
  }

  private PriorityQueue<Pair> buildHeap(Node[] nodes) {
    final Comparator<Pair> comparator = (a, b) -> {
      if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
      return a.left.index - b.left.index;
    };
    final PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);

    for (int i = 0; i < nodes.length - 1; i++) {
      pq.add(new Pair(nodes[i].val + nodes[i + 1].val, nodes[i]));
    }

    return pq;
  }

  private Node[] buildDoublyLinkedList(int[] nums) {
    final Node[] nodes = new Node[nums.length];

    for (int i = 0; i < nums.length; i++) {
      nodes[i] = new Node(i, nums[i]);
    }

    for (int i = 0; i < nodes.length; i++) {
      if (i > 0) nodes[i].prev = nodes[i - 1];
      if (i < nodes.length - 1) nodes[i].next = nodes[i + 1];
    }

    return nodes;
  }

  static void main() {
    final var test = new MinimumPairRemovalToSortArrayII();
    System.out.println(test.minimumPairRemoval(new int[] { 2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1 }));
  }
}
