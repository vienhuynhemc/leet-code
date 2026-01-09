/* vienhuynhemc */
import model.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

  private record Pair(TreeNode first, int second) {}

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return findMaxDeepest(root, 0).first;
  }

  private Pair findMaxDeepest(TreeNode root, int deep) {
    if (root.left == null && root.right == null) {
      return new Pair(root, deep);
    }

    if (root.left != null && root.right != null) {
      final Pair left = findMaxDeepest(root.left, deep + 1);
      final Pair right = findMaxDeepest(root.right, deep + 1);

      if (left.second > right.second) {
        return new Pair(left.first, left.second);
      } else if (left.second < right.second) {
        return new Pair(right.first, right.second);
      } else {
        return new Pair(root, left.second);
      }
    } else if (root.left != null) {
      final Pair left = findMaxDeepest(root.left, deep + 1);
      return new Pair(left.first, left.second);
    } else {
      final Pair right = findMaxDeepest(root.right, deep + 1);
      return new Pair(right.first, right.second);
    }
  }
}
