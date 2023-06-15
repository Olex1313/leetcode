package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(0, -1);
        this.tail = new Node(0, -1);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            if (map.size() > capacity) {
                Node tail = popTail();
                map.remove(tail.key);
            }
        } else {
            moveToHead(node);
            node.val = value;
        }
    }

    private Node popTail() {
        Node tailPrev = tail.next;
        removeNode(tailPrev);
        return tailPrev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        // d - 2 - 1 - d
        Node pre = node.prev;
        Node nex = node.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node node) {
        node.prev = head.prev;
        node.next = head;
        head.prev.next = node;
        head.prev = node;
    }

    static class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

}
