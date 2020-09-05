package AllElementsInTwoBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

import Common.TreeNode;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);

        return merge(l1, l2);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j))
                res.add(l1.get(i++));
            else
                res.add(l2.get(j++));
        }

        while (i < l1.size())
            res.add(l1.get(i++));
        while (j < l2.size())
            res.add(l2.get(j++));

        return res;
    }
}
