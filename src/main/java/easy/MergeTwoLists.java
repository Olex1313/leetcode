package easy;

import org.junit.jupiter.params.ParameterizedTest;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), end = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                end.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                end.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            end = end.next;
        }
        if (list1 != null) {
            while (list1 != null) {
                end.next = new ListNode(list1.val);
                list1 = list1.next;
                end = end.next;
            }
        } else {
            while (list2 != null) {
                end.next = new ListNode(list2.val);
                list2 = list2.next;
                end = end.next;
            }
        }
        return head.next;
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
