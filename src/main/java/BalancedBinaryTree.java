/* vienhuynhemc */
import model.TreeNode;

public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    return getValidHeightBalanced(root, 0) != -1;
  }

  public int getValidHeightBalanced(TreeNode root, int curHeight) {
    if (root == null) return curHeight;

    final int leftHeight = getValidHeightBalanced(root.left, curHeight + 1);
    if (leftHeight == -1) return -1;

    final int rightHeight = getValidHeightBalanced(root.right, curHeight + 1);
    if (rightHeight == -1) return -1;

    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    return Math.max(leftHeight, rightHeight);
  }
}
