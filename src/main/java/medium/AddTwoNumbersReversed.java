package medium;

import java.util.Stack;

public class AddTwoNumbersReversed {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        ListNode head = null;
        int overflow = 0;

        while (l1 != null) {
            first.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            second.add(l2.val);
            l2 = l2.next;
        }

        while (!first.isEmpty() || !second.isEmpty() || overflow != 0) {
            int a = second.isEmpty() ? 0 : second.pop();
            int b = first.isEmpty() ? 0 : first.pop();
            int sum = a + b + overflow;
            overflow = sum / 10;
            ListNode current = new ListNode(sum % 10);
            current.next = head;
            head = current;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
