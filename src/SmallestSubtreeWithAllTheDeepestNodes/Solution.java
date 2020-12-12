package SmallestSubtreeWithAllTheDeepestNodes;

import Common.Pair;
import Common.TreeNode;

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode node) {
        if (node == null)
            return new Pair<>(0, null);
        Pair<Integer, TreeNode> left = dfs(node.left), right = dfs(node.right);
        int depth1 = left.getKey(), depth2 = right.getKey();
        return new Pair<>(Math.max(depth1, depth2) + 1,
                depth1 == depth2 ? node : depth1 > depth2 ? left.getValue() : right.getValue());
    }
}
