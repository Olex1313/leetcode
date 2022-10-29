package medium;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public void removeDuplicates(Node head) {
        Set<Integer> seen = new HashSet<>();
        Node prev = null;
        while (head != null) {
            if (seen.contains(head.val)) {
                prev.next = head.next;
            } else {
                seen.add(head.val);
                prev = head;
            }
            head = head.next;
        }
    }

    public void removeDuplicatesWithNoBuffer(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public static NodeBuilder builder() {
            return new NodeBuilder();
        }

        static class NodeBuilder {
            private Node top;

            public NodeBuilder withNode(int val) {
                if (top == null) {
                    top = new Node(val, null);
                    return this;
                }
                var traversal = top;
                while (traversal.next != null) {
                    traversal = traversal.next;
                }
                traversal.next = new Node(val, null);
                return this;
            }

            Node build() {
                return top;
            }

        }
    }

}
