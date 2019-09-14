package PopulatingNextRightPointersInEachNodeII;

import Common.Node;

class Solution {
    public Node connect(Node root) {
        Node iter = root;

        while (iter != null) {
            Node dummy = new Node();
            Node current = dummy;

            while (iter != null) {
                if (iter.left != null) {
                    current.next = iter.left;
                    current = current.next;
                }

                if (iter.right != null) {
                    current.next = iter.right;
                    current = current.next;
                }

                iter = iter.next;
            }

            iter = dummy.next;
        }

        return root;
    }
}
