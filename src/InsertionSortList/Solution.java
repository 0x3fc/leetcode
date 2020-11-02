package InsertionSortList;

import Common.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode iter = null, next = null;

        while (head != null) {
            next = head.next;

            if (iter == null || iter.val >= head.val)
                iter = dummy;

            while (iter.next != null && iter.next.val < head.val) {
                iter = iter.next;
            }

            head.next = iter.next;
            iter.next = head;
            head = next;
        }

        return dummy.next;
    }
}