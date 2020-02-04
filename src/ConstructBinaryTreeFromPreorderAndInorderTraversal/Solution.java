package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

import Common.TreeNode;

class Solution {
    int[] preorder;
    int[] inorder;
    int p = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int i, int j) {
        if (i > j)
            return null;

        int rootVal = preorder[p++];
        TreeNode root = new TreeNode(rootVal);
        if (i == j)
            return root;

        int idx = map.get(rootVal);
        root.left = build(i, idx - 1);
        root.right = build(idx + 1, j);
        return root;
    }
}
