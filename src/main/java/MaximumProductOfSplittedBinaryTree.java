/* vienhuynhemc */
import model.TreeNode;

public class MaximumProductOfSplittedBinaryTree {

  private static final int MOD = 1000000007;

  public int maxProduct(TreeNode root) {
    final long sum = calSum(root);
    final long[] maxProduct = new long[1];
    findMaxProductByDFS(root, sum, maxProduct);

    return (int) (maxProduct[0] % MOD);
  }

  private long findMaxProductByDFS(TreeNode root, long totalSum, long[] maxProduct) {
    if (root == null) {
      return 0;
    }

    final long sumLeft = findMaxProductByDFS(root.left, totalSum, maxProduct);
    final long sumRight = findMaxProductByDFS(root.right, totalSum, maxProduct);

    final long sum = root.val + sumLeft + sumRight;
    final long product = sum * (totalSum - sum);
    if (product > maxProduct[0]) {
      maxProduct[0] = product;
    }

    return sum;
  }

  private long calSum(TreeNode root) {
    return root == null ? 0 : root.val + calSum(root.left) + calSum(root.right);
  }
}
