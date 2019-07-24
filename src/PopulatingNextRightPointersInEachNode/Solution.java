package PopulatingNextRightPointersInEachNode;

import Common.Node;

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.next != null && root.next.left != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}
