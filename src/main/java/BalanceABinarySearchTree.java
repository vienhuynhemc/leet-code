/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;
import model.TreeNode;

public class BalanceABinarySearchTree {

  public TreeNode balanceBST(TreeNode root) {
    final List<Integer> data = new ArrayList<>();
    browserTreeAndCollectData(root, data);

    int middle = data.size() / 2;

    final TreeNode newRoot = new TreeNode(data.get(middle));
    buildBinarySearchTree(newRoot, data, 0, middle - 1);
    buildBinarySearchTree(newRoot, data, middle + 1, data.size() - 1);

    return newRoot;
  }

  private void buildBinarySearchTree(TreeNode parent, List<Integer> data, int leftIndex, int rightIndex) {
    if (leftIndex > rightIndex) return;

    if (leftIndex == rightIndex) {
      buildNewNode(parent, data, leftIndex);
      return;
    }

    int mid = (leftIndex + rightIndex) / 2;
    final TreeNode newNode = buildNewNode(parent, data, mid);

    buildBinarySearchTree(newNode, data, leftIndex, mid - 1);
    buildBinarySearchTree(newNode, data, mid + 1, rightIndex);
  }

  private TreeNode buildNewNode(TreeNode parent, List<Integer> data, int index) {
    final TreeNode newNode = new TreeNode(data.get(index));

    if (newNode.val > parent.val) parent.right = newNode;
    else parent.left = newNode;

    return newNode;
  }

  private void browserTreeAndCollectData(TreeNode root, List<Integer> data) {
    if (root.left != null) browserTreeAndCollectData(root.left, data);

    data.add(root.val);

    if (root.right != null) browserTreeAndCollectData(root.right, data);
  }
}
