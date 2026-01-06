/* vienhuynhemc */
import java.util.LinkedList;
import java.util.Queue;
import model.TreeNode;

public class MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(TreeNode root) {
    final Queue<TreeNode> stack = new LinkedList<>();

    int level = 1;
    int maxLevelSum = 1;
    int maxSum = root.val;
    int length = 0;
    if (root.left != null) {
      stack.add(root.left);
      length++;
    }
    if (root.right != null) {
      stack.add(root.right);
      length++;
    }

    while (!stack.isEmpty()) {
      level++;

      int tempSum = 0;
      int tempLength = 0;
      for (int i = 0; i < length; i++) {
        final TreeNode node = stack.poll();
        if (node == null) {
          continue;
        }
        tempSum += node.val;

        if (node.left != null) {
          stack.add(node.left);
          tempLength++;
        }
        if (node.right != null) {
          stack.add(node.right);
          tempLength++;
        }
      }

      if (tempSum > maxSum) {
        maxSum = tempSum;
        maxLevelSum = level;
      }

      length = tempLength;
    }

    return maxLevelSum;
  }
}
