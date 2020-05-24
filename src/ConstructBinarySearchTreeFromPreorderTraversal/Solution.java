package ConstructBinarySearchTreeFromPreorderTraversal;

import Common.TreeNode;

class Solution {
    private int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int max) {
        if (i >= preorder.length || preorder[i] >= max)
            return null;

        TreeNode root = new TreeNode(preorder[i]);
        i++;

        root.left = build(preorder, root.val);
        root.right = build(preorder, max);

        return root;
    }
}
