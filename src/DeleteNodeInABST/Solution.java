package DeleteNodeInABST;

import Common.TreeNode;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null && curr.val != key) {
            prev = curr;
            curr = curr.val < key ? curr.right : curr.left;
        }

        if (prev == null)
            return deleteRootNode(curr);

        if (prev.left == curr) {
            prev.left = deleteRootNode(curr);
        } else if (prev.right == curr) {
            prev.right = deleteRootNode(curr);
        }

        return root;
    }

    private TreeNode deleteRootNode(TreeNode node) {
        if (node == null)
            return null;

        if (node.left == null)
            return node.right;
        if (node.right == null)
            return node.left;

        TreeNode curr = node.right;
        TreeNode prev = null;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }

        curr.left = node.left;
        if (node.right != curr) {
            prev.left = curr.right;
            curr.right = node.right;
        }
        return curr;
    }
}
