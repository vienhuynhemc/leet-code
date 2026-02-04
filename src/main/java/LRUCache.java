/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private static final class Node {

    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private final Map<Integer, Node> database;
  private final int capacity;

  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    database = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    final Node node = database.get(key);
    if (node == null) return -1;

    moveToHead(node);

    return node.val;
  }

  public void put(int key, int value) {
    final Node node = database.get(key);
    if (node != null) {
      node.val = value;
      moveToHead(node);
      return;
    }

    if (database.size() == capacity) {
      database.remove(tail.key);
      removeNode(tail);
    }

    final Node newNode = new Node(key, value);
    database.put(key, newNode);
    addToHead(newNode);
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }

  private void addToHead(Node node) {
    node.prev = null;
    node.next = head;

    if (head != null) head.prev = node;
    head = node;
    if (tail == null) tail = node;
  }

  private void removeNode(Node node) {
    if (node.prev != null) node.prev.next = node.next;
    else head = node.next;

    if (node.next != null) node.next.prev = node.prev;
    else tail = node.prev;
  }
}
