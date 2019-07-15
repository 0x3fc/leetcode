package BinaryTreeLevelOrderTraversal;

import java.util.*;
import Common.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, root, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (res.size() <= height) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(node.val);

        dfs(res, node.left, height + 1);
        dfs(res, node.right, height + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
