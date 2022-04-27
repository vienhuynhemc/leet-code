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

var increasingBST = function (root) {
    let nodes = [];
    if (root != null) {
        browserTree(root, nodes);
        nodes.sort((a, b) => a.val - b.val);
        for (let i = nodes.length - 1; i >= 0; i--) {
            if (i === nodes.length - 1) {
                nodes[i].right = null;
                nodes[i].left = null;
            } else {
                nodes[i].left = null;
                nodes[i].right = nodes[i + 1];
            }
        }
    }
    return nodes[0];
};

function browserTree(node, nodes) {
    nodes.push(node);
    if (node.left != null) browserTree(node.left, nodes);
    if (node.right != null) browserTree(node.right, nodes);
}
