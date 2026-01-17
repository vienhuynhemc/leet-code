/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessTasksUsingServers {

  public int[] assignTasks(int[] servers, int[] tasks) {
    final int[] result = new int[tasks.length];
    final ServerHeap<AvailableServer> availableServerHeap = new ServerHeap<>(servers.length);
    final ServerHeap<BusyServer> busyServerHeap = new ServerHeap<>(servers.length);

    for (int i = 0; i < servers.length; i++) {
      availableServerHeap.add(new AvailableServer(servers[i], i));
    }

    int time = 0;
    for (int i = 0; i < tasks.length; i++) {
      time = Math.max(time, i);

      while (busyServerHeap.peek() != null && busyServerHeap.peek().freeTime <= time) {
        final BusyServer busyServer = busyServerHeap.poll();
        availableServerHeap.add(new AvailableServer(busyServer.weight, busyServer.index));
      }

      if (availableServerHeap.peek() == null) {
        time = busyServerHeap.peek().freeTime;
        while (busyServerHeap.peek() != null && busyServerHeap.peek().freeTime <= time) {
          final BusyServer busyServer = busyServerHeap.poll();
          availableServerHeap.add(new AvailableServer(busyServer.weight, busyServer.index));
        }
      }

      final AvailableServer availableServer = availableServerHeap.poll();
      busyServerHeap.add(new BusyServer(availableServer.weight, availableServer.index, time + tasks[i]));
      result[i] = availableServer.index;
    }

    return result;
  }

  private interface Server<T> {
    boolean isPreferThan(T t);
  }

  private record AvailableServer(int weight, int index) implements Server<AvailableServer> {
    public boolean isPreferThan(AvailableServer server) {
      return weight == server.weight ? index < server.index : weight < server.weight;
    }
  }

  private record BusyServer(int weight, int index, int freeTime) implements Server<BusyServer> {
    public boolean isPreferThan(BusyServer server) {
      return freeTime < server.freeTime;
    }
  }

  private static class ServerHeap<T extends Server<T>> {

    private final List<T> servers;

    public ServerHeap(int size) {
      this.servers = new ArrayList<>(size);
    }

    public T peek() {
      return servers.isEmpty() ? null : servers.getFirst();
    }

    public void add(T server) {
      servers.add(server);
      heapifyUp(servers.size() - 1);
    }

    public T poll() {
      final T result = servers.getFirst();

      servers.set(0, servers.getLast());
      servers.removeLast();
      heapifyDown(0);

      return result;
    }

    private void heapifyDown(int index) {
      final int leftIndex = index * 2 + 1;
      if (leftIndex >= servers.size()) {
        return;
      }

      final int rightIndex = leftIndex + 1;
      int preferredIndex = leftIndex;
      if (rightIndex < servers.size() && servers.get(rightIndex).isPreferThan(servers.get(leftIndex))) {
        preferredIndex = rightIndex;
      }

      if (servers.get(preferredIndex).isPreferThan(servers.get(index))) {
        swap(index, preferredIndex);
        heapifyDown(preferredIndex);
      }
    }

    private void heapifyUp(int index) {
      if (index == 0) {
        return;
      }

      final int parentIndex = (index - 1) / 2;
      if (servers.get(index).isPreferThan(servers.get(parentIndex))) {
        swap(index, parentIndex);
        heapifyUp(parentIndex);
      }
    }

    private void swap(int i, int j) {
      final T temp = servers.get(i);
      servers.set(i, servers.get(j));
      servers.set(j, temp);
    }
  }

  static void main() {
    final ProcessTasksUsingServers test = new ProcessTasksUsingServers();
    System.out.println(Arrays.toString(test.assignTasks(new int[] { 3, 3, 2 }, new int[] { 1, 2, 3, 2, 1, 2 })));
  }
}
