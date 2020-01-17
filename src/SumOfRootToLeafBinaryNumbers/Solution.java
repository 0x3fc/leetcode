package SumOfRootToLeafBinaryNumbers;

import Common.TreeNode;

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        val = val << 1 | node.val;

        if (node.left == null && node.right == null) {
            return val;
        }

        return sum(node.left, val) + sum(node.right, val);
    }
}
