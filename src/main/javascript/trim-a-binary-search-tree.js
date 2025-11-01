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
 * @param {number} low
 * @param {number} high
 * @return {TreeNode}
 */

class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

var trimBST = function (root, low, high) {
  if (root == null) return root;
  root.left = trimBST(root.left, low, high);
  root.right = trimBST(root.right, low, high);

  if (root.val < low) return root.right;
  else if (root.val > high) return root.left;
  return root;
};

console.log(
  trimBST(
    new TreeNode(1, new TreeNode(0, null, null), new TreeNode(2, null, null)),
    1,
    2,
  ),
);
