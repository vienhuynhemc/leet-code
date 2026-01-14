/* vienhuynhemc */
public class SeatReservationManager {

  private static class SeatManager {

    private final int[] heap;
    private int size;

    public SeatManager(int n) {
      heap = new int[n];
      for (int i = 0; i < n; i++) {
        heap[i] = i + 1;
      }
      size = n;
    }

    public int reserve() {
      final int result = heap[0];
      removeRoot();
      return result;
    }

    public void unreserve(int seatNumber) {
      heap[size] = seatNumber;
      heapifyUp(size);
      size++;
    }

    private void removeRoot() {
      size--;
      heap[0] = heap[size];
      heapifyDown(0);
    }

    private void heapifyDown(int index) {
      final int leftIndex = index * 2 + 1;
      if (leftIndex >= size) {
        return;
      }

      final int rightIndex = leftIndex + 1;
      int smallestIndex = leftIndex;

      if (rightIndex < size && heap[rightIndex] < heap[leftIndex]) {
        smallestIndex = rightIndex;
      }

      if (heap[smallestIndex] >= heap[index]) {
        return;
      }

      swap(index, smallestIndex);
      heapifyDown(smallestIndex);
    }

    private void heapifyUp(int index) {
      final int parentIndex = (index - 1) / 2;
      if (heap[index] >= heap[parentIndex]) {
        return;
      }

      swap(index, parentIndex);
      heapifyUp(parentIndex);
    }

    private void swap(int i, int j) {
      final int tmp = heap[i];
      heap[i] = heap[j];
      heap[j] = tmp;
    }
  }

  static void main() {
    final SeatManager manager = new SeatManager(5);
    System.out.println(manager.reserve());
    System.out.println(manager.reserve());
    manager.unreserve(2);
    System.out.println(manager.reserve());
    System.out.println(manager.reserve());
    System.out.println(manager.reserve());
    System.out.println(manager.reserve());
    manager.unreserve(5);
  }
}
