package ReorderList;

import Common.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        // Find mid point
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // Merge two linked list
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
