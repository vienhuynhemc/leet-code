/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */

class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

var searchBST = function (root, val) {
  if (root.val === val) return root;
  if (val > root.val) {
    if (root.right != null) {
      return searchBST(root.right, val);
    } else {
      return null;
    }
  } else {
    if (root.left != null) {
      return searchBST(root.left, val);
    } else {
      return null;
    }
  }
};

console.log(
  searchBST(
    new TreeNode(
      4,
      new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
      new TreeNode(7, null, null),
    ),
    2,
  ),
);

console.log(
  searchBST(
    new TreeNode(
      4,
      new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
      new TreeNode(7, null, null),
    ),
    5,
  ),
);
