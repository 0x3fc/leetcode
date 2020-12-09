package BinarySearchTreeIterator;

import java.util.Stack;

import Common.TreeNode;

class BSTIterator {

    private Stack<TreeNode> parents = new Stack<>();

    public BSTIterator(TreeNode root) {
        addNext(root);
    }

    public int next() {
        TreeNode node = parents.pop();
        addNext(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !parents.isEmpty();
    }

    private void addNext(TreeNode node) {
        while (node != null) {
            parents.add(node);
            node = node.left;
        }
    }
}
