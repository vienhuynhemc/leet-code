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
 * @return {void} Do not return anything, modify root in-place instead.
 */

class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

var flatten = function (root) {
  if (root != null) {
    let nodes = [];
    browserTree(root, nodes);
    for (let i = nodes.length - 1; i >= 0; i--) {
      if (i == nodes.length - 1) {
        nodes[i].right = null;
        nodes[i].left = null;
      } else {
        nodes[i].left = null;
        nodes[i].right = nodes[i + 1];
      }
    }
  }
  return root;
};

function browserTree(node, nodes) {
  nodes.push(node);
  if (node.left != null) browserTree(node.left, nodes);
  if (node.right != null) browserTree(node.right, nodes);
}

console.log(
  flatten(
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
      new TreeNode(5, null, new TreeNode(6, null, null))
    )
  )
);
