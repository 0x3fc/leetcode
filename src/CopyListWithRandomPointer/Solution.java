package CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Node cloneDummy = new Node();
        Node iter = head;
        Map<Node, Node> m = new HashMap<>();
        Node cloneIter = cloneDummy;
        
        while (iter != null) {
            cloneIter.next = new Node();
            cloneIter = cloneIter.next;
            cloneIter.val = iter.val;
            m.put(iter, cloneIter);
            iter = iter.next;
        }
        
        iter = head;
        while (iter != null) {
            m.get(iter).random = m.get(iter.random);
            iter = iter.next;
        }
        
        return cloneDummy.next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;
    
        public Node() {}
    
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
