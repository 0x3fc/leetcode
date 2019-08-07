package KthSmallestElementInABST;

import Common.TreeNode;

class Solution {
    private static int count = 0;
    private static int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;

        inorder(root);

        return val;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (--count == 0) {
            val = node.val;
            return;
        }

        inorder(node.right);
    }
}
