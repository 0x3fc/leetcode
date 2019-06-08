package MergeKSortedLists;

import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }

            iter = iter.next;
        }

        iter.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });

        for (ListNode n : lists) {
            if (n != null) {
                pq.add(n);
            }
        }

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();

            if (n.next != null) {
                pq.add(n.next);
            }

            iter.next = new ListNode(n.val);
            iter = iter.next;
        }

        return dummy.next;
    }
}
