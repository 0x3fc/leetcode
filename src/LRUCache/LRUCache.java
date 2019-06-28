package LRUCache;

import java.util.*;

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            updateNode(key, value);
            return;
        }

        if (cache.size() == capacity) {
            dropLast();
        }

        addNode(new Node(key, value));
    }

    private void moveToFront(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void updateNode(int key, int value) {
        Node node = cache.get(key);
        node.value = value;
        moveToFront(node);
    }

    private void dropLast() {
        Node node = tail.prev;

        tail.prev = node.prev;
        node.prev.next = tail;

        cache.remove(node.key);
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        node.next.prev = node;
        head.next = node;

        cache.put(node.key, node);
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    protected int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
