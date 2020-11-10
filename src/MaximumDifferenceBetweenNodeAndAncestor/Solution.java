package MaximumDifferenceBetweenNodeAndAncestor;

import Common.TreeNode;

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int left = dfs(root.left, min, max);
        int right = dfs(root.right, min, max);

        return Math.max(left, right);
    }
}
