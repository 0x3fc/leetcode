package RecoverBinarySearchTree;

import Common.TreeNode;

class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.left);

        if (first == null && node.val < prev.val) {
            first = prev;
        }

        if (first != null && node.val < prev.val) {
            second = node;
        }

        prev = node;

        dfs(node.right);
    }
}
