package medium;

class MinStack {

    private Node top;

    public MinStack() {
        top = null;
    }

    public void push(int val) {
        int min = (top == null) ? val : Math.min(top.min, val);
        top = new Node(val, min, top);
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

}
