package SerializeAndDeserializeBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        StringBuilder sb = new StringBuilder();
        values.forEach(value -> {
            sb.append(value);
            sb.append(" ");
        });
        return sb.toString();
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null)
            return;
        values.add(node.val);
        inorder(node.left, values);
        inorder(node.right, values);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        List<Integer> values = new ArrayList<>();
        for (String value : data.split(" ")) {
            values.add(Integer.parseInt(value));
        }
        return build(values, -1);
    }

    private int i = 0;

    private TreeNode build(List<Integer> values, int max) {
        if (i >= values.size() || (max != -1 && values.get(i) >= max))
            return null;

        int value = values.get(i);
        i++;

        TreeNode node = new TreeNode(value);
        node.left = build(values, value);
        node.right = build(values, max);
        return node;
    }

    public TreeNode deserializeUsingQueue(String data) {
        if ("".equals(data))
            return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        return deserializeQueueHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeQueueHelper(Queue<String> queue, int min, int max) {
        if (queue.size() == 0)
            return null;
        int value = Integer.parseInt(queue.peek());
        if (value <= min || value >= max)
            return null;
        queue.poll();
        TreeNode node = new TreeNode(value);
        node.left = deserializeQueueHelper(queue, min, value);
        node.right = deserializeQueueHelper(queue, value, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
