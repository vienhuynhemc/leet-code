/* vienhuynhemc */
import model.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

  public int sumRootToLeaf(TreeNode root) {
    return sumRootToLeaf(root, "");
  }

  public int sumRootToLeaf(TreeNode node, String curPath) {
    final String nextPath = curPath + node.val;

    if (node.left == null && node.right == null) return convertBinaryToDecimal(nextPath);

    int result = 0;
    if (node.left != null) result += sumRootToLeaf(node.left, nextPath);
    if (node.right != null) result += sumRootToLeaf(node.right, nextPath);

    return result;
  }

  private int convertBinaryToDecimal(String binary) {
    final char[] chars = binary.toCharArray();
    int result = 0;

    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] == '0') continue;
      result += (int) Math.pow(2, chars.length - i - 1);
    }

    return result;
  }
}
