package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> clones = new HashMap<>();
        cloneNodes(node, clones);
        assignNeighbors(node, clones);
        return clones.get(node.val);
    }

    private void cloneNodes(Node node, Map<Integer, Node> clones) {
        if (clones.containsKey(node.val))
            return;
        clones.put(node.val, new Node(node.val));
        for (Node neighbor : node.neighbors)
            cloneNodes(neighbor, clones);
    }

    private void assignNeighbors(Node node, Map<Integer, Node> clones) {
        Node cloned = clones.get(node.val);
        if (node.neighbors.size() == cloned.neighbors.size())
            return;
        for (Node neighbor : node.neighbors)
            cloned.neighbors.add(clones.get(neighbor.val));
        for (Node neighbor : node.neighbors)
            assignNeighbors(neighbor, clones);
    }

    private Map<Integer, Node> clones = new HashMap<>();

    public Node cloneGraphOneMethod(Node node) {
        if (node == null)
            return null;
        if (clones.containsKey(node.val))
            return clones.get(node.val);
        Node cloned = new Node(node.val);
        clones.put(node.val, cloned);
        for (Node neighbor : node.neighbors)
            cloned.neighbors.add(cloneGraph(neighbor));
        return cloned;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
