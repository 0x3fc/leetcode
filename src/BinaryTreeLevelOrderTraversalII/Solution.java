package BinaryTreeLevelOrderTraversalII;

import java.util.*;
import Common.TreeNode;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                row.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            res.add(0, row);
        }

        return res;
    }
}
