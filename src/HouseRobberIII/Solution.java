package HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

import Common.TreeNode;

class Solution {
    private Map<TreeNode, Integer> m = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (m.containsKey(root))
            return m.get(root);

        int sum = 0;

        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }

        int res = Math.max(root.val + sum, rob(root.left) + rob(root.right));
        m.put(root, res);
        return res;
    }

    public int robBottomUp(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robHelper(TreeNode node) { // [robNode, notRobNode]
        int[] res = new int[2];
        if (node == null)
            return res;

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        res[0] = left[1] + right[1] + node.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
