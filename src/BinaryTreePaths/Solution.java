package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

import Common.TreeNode;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, root);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, TreeNode node) {
        if (node.left == null && node.right == null) {
            path.append(node.val);
            res.add(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }

        int length = path.length();
        if (node.left != null) {
            path.append(node.val).append("->");
            dfs(res, path, node.left);
            path.setLength(length);
        }

        if (node.right != null) {
            path.append(node.val).append("->");
            dfs(res, path, node.right);
            path.setLength(length);
        }
    }
}
