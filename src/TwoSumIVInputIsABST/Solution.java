package TwoSumIVInputIsABST;

import java.util.*;
import Common.TreeNode;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<>();

        // Inorder traversal on BST gives a sorted list
        inorder(root, sorted);

        int l = 0;
        int r = sorted.size() - 1;

        while (l < r) {
            int sum = sorted.get(l) + sorted.get(r);

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }

    private void inorder(TreeNode node, List<Integer> sorted) {
        if (node == null) {
            return;
        }

        inorder(node.left, sorted);
        sorted.add(node.val);
        inorder(node.right, sorted);
    }

    public boolean findTarget2(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (search(root, node, k - node.val)) {
            return true;
        }

        return dfs(root, node.left, k) || dfs(root, node.right, k);
    }

    private boolean search(TreeNode node, TreeNode nonRepeatedNode, int target) {
        if (node == null) {
            return false;
        }

        if ((node.val == target) && (node != nonRepeatedNode)) {
            return true;
        }

        return node.val < target ? search(node.right, nonRepeatedNode, target)
                : search(node.left, nonRepeatedNode, target);
    }
}
