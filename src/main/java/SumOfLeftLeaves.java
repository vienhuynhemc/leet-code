
import src.main.java.model.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return process(root, false);
    }

    private int process(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node)) {
            return isLeft ? node.val : 0;
        }

        return process(node.left, true) + process(node.right, false);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
