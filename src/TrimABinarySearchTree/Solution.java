package TrimABinarySearchTree;

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val > R) {
            return trimBST1(root.right, L, R);
        }

        if (root.val < L) {
            return trimBST1(root.left, L, R);
        }

        root.left = trimBST1(root.left, L, R);
        root.right = trimBST1(root.right, L, R);

        return root;
    }
}
