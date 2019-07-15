package SymmetricTree;

import Common.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetricHelper(left.right, right.left)
                && isSymmetricHelper(left.left, right.right);
    }
}
