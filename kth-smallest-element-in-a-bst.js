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
 * @param {number} k
 * @return {number}
 */

class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

var kthSmallest = function (root, k) {
  let nodes = [];
  if (root != null) {
    browserTree(root, nodes);
    for (let i = nodes.length - 1; i >= 0; i--) {
      nodes[i].right = null;
      nodes[i].left = null;
    }
    nodes.sort((a, b) => a.val - b.val);
  }
  return nodes[k - 1].val;
};

function browserTree(node, nodes) {
  nodes.push(node);
  if (node.left != null) browserTree(node.left, nodes);
  if (node.right != null) browserTree(node.right, nodes);
}

console.log(
  kthSmallest(
    new TreeNode(
      3,
      new TreeNode(1, null, new TreeNode(2, null, null)),
      new TreeNode(4, null, null)
    ),
    1
  )
);

console.log(
  kthSmallest(
    new TreeNode(
      5,
      new TreeNode(
        3,
        new TreeNode(2, new TreeNode(1, null, null), null),
        new TreeNode(4, null, null)
      ),
      new TreeNode(6, null, null)
    ),
    3
  )
);
