package medium;

import java.util.LinkedList;
import java.util.Queue;

public class LinkTreeNodesToRight {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node right = null;
            for (int i = queue.size(); i > 0; i--) {
                var node = queue.poll();
                node.next = right;
                right = node;
                if (node.right != null) {
                    queue.add(node.right);
                    queue.add(node.left);
                }
            }
        }
        return root;
    }

    public Node connectRecursive(Node root) {
        if (root == null) return null;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
