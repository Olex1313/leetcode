package medium;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode rHead = new ListNode(0), rEnd = rHead;
        ListNode lHead = new ListNode(0), lEnd = lHead;
        while (head != null) {
            if (head.val < x) {
                lEnd.next = head;
                lEnd = lEnd.next;
            } else {
                rEnd.next = head;
                rEnd = rEnd.next;
            }
            head = head.next;
        }
        lEnd.next = rHead.next;
        rEnd.next = null;
        return lHead.next;
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
