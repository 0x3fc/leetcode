package BinaryTreePostorderTraversal;

import java.util.*;
import Common.TreeNode;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorder(res, root);

        return res;
    }

    private void postorder(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }

        postorder(res, node.left);
        postorder(res, node.right);
        res.add(node.val);
    }
}
