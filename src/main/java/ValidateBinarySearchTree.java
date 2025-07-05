package src.main.java;

import src.main.java.model.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left, true, root.val) && isValidBST(root.right, false, root.val);
    }

    private boolean isValidBST(TreeNode root, boolean isLeft, int limit) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, true, isLeft, isLeft ? 0 : limit, root.val, !isLeft)
                && isValidBST(root.right, false, isLeft, root.val, isLeft ? limit : 0, isLeft);
    }

    private boolean isValidBST(TreeNode root, boolean isLeft, boolean isBeforeLeft, int bottom, int top, boolean isDifferent) {
        if (root == null) {
            return true;
        }
        if (isBeforeLeft) {
            if (isLeft) {
                if ((isDifferent && root.val <= bottom) || root.val >= top) {
                    return false;
                }
                return isValidBST(root.left, true, true, bottom, root.val, isDifferent)
                        && isValidBST(root.right, false, true, root.val, top, true);
            } else {
                if (root.val <= bottom || root.val >= top) {
                    return false;
                }
                return isValidBST(root.left, true, false, bottom, root.val, true)
                        && isValidBST(root.right, false, false, root.val, top, isDifferent);
            }
        } else {
            if (isLeft) {
                if (root.val <= bottom || root.val >= top) {
                    return false;
                }
                return isValidBST(root.left, true, true, bottom, root.val, isDifferent)
                        && isValidBST(root.right, false, true, root.val, top, true);
            } else {
                if ((isDifferent && root.val >= top) || root.val <= bottom) {
                    return false;
                }
                return isValidBST(root.left, true, false, bottom, root.val, true)
                        && isValidBST(root.right, false, false, root.val, top, isDifferent);
            }
        }
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(validateBinarySearchTree.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
        System.out.println(validateBinarySearchTree.isValidBST(new TreeNode(0, new TreeNode(-1), null)));
        System.out.println(validateBinarySearchTree.isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
        System.out.println(validateBinarySearchTree.isValidBST(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)))));
    }

}
