package ValidateBinarySearchTree;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }

        int val = n.val;

        if (min != null && val <= min) {
            return false;
        }

        if (max != null && val >= max) {
            return false;
        }

        return helper(n.right, val, max) && helper(n.left, min, val);
    }
}
