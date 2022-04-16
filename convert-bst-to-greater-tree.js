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
 * @return {TreeNode}
 */

class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

var convertBST = function (root) {
  if (root != null) {
    let cloneRoot = cloneRootFromRoot(root);
    browser(root, cloneRoot);
  }
  return root;
};

function cloneRootFromRoot(node) {
  let cloneNode = new TreeNode(node.val, null, null);
  if (node.left != null) {
    cloneNode.left = cloneRootFromRoot(node.left);
  }
  if (node.right != null) {
    cloneNode.right = cloneRootFromRoot(node.right);
  }
  return cloneNode;
}

function browser(node, root) {
  node.val = getSum(root, node.val);
  if (node.left != null) {
    browser(node.left, root);
  }
  if (node.right != null) {
    browser(node.right, root);
  }
}

function getSum(node, limit) {
  let sum = 0;
  if (node.val >= limit) {
    sum += node.val;
  }
  if (node.left != null) {
    sum += getSum(node.left, limit);
  }
  if (node.right != null) {
    sum += getSum(node.right, limit);
  }
  return sum;
}

console.log(
  convertBST(
    new TreeNode(
      4,
      new TreeNode(
        1,
        new TreeNode(0, null, null),
        new TreeNode(2, null, new TreeNode(3, null, null))
      ),
      new TreeNode(
        6,
        new TreeNode(5, null, null),
        new TreeNode(7, null, new TreeNode(8, null, null))
      )
    )
  )
);
