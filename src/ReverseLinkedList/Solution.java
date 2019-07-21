package ReverseLinkedList;

import Common.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = node;
        }

        return dummy.next;
    }
}
