/* vienhuynhemc */
import model.TreeNode;

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    return process(root, 0);
  }

  private int process(TreeNode node, int val) {
    int updatedVal = val * 10 + node.val;
    if (isLeaf(node)) {
      return updatedVal;
    }

    int total = 0;
    if (node.left != null) {
      total += process(node.left, updatedVal);
    }
    if (node.right != null) {
      total += process(node.right, updatedVal);
    }

    return total;
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }
}
