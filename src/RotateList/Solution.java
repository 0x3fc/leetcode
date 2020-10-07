package RotateList;

import Common.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int i = 0;
        for (; fast.next != null; i++) {
            fast = fast.next;
        }

        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public ListNode rotateRightWithoutDummy(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        ListNode last = head;
        int count = 1;
        while (last.next != null) {
            last = last.next;
            count++;
        }

        ListNode pivot = head;
        int pos = count - k % count;
        while (pos > 1) {
            pivot = pivot.next;
            pos--;
        }

        last.next = head;
        head = pivot.next;
        pivot.next = null;

        return head;
    }

    public ListNode rotateRightFormCircle(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        int count = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            count++;
        }

        iter.next = head;

        int pos = count - k % count;
        while (pos > 0) {
            iter = iter.next;
            pos--;
        }

        head = iter.next;
        iter.next = null;
        return head;
    }
}
