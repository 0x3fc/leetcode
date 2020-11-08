package BinaryTreeTilt;

import Common.TreeNode;

class Solution {
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        int left = findTilt(root.left);
        int right = findTilt(root.right);

        int leftSum = root.left == null ? 0 : root.left.val;
        int rightSum = root.right == null ? 0 : root.right.val;
        root.val += leftSum + rightSum;

        return left + right + Math.abs(leftSum - rightSum);
    }
}
