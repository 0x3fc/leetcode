package SortList;

import Common.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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

        if (l1 != null) {
            iter.next = l1;
        } else {
            iter.next = l2;
        }

        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;

        while (head != null) {
            head = head.next;
            length++;
        }

        for (int step = 1; step < length; step <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);

                curr = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;

        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode curr = prev;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        } else if (right != null) {
            curr.next = right;
        }

        while (curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }

    public ListNode sortList3(ListNode head) {
        ListNode dummy = new ListNode(0);

        helper(dummy, head, null);

        return dummy.next;
    }

    private void helper(ListNode pre, ListNode head, ListNode last) {
        if (head == last) {
            pre.next = last;
            return;
        }

        ListNode ppre = pre;
        ListNode index = head;
        ListNode dummy = new ListNode(0);
        ListNode plast = index;
        dummy.next = index;

        // head是所有需要排序的节点
        // ppre是所有<index.val的节点链接的终点
        // dummy是所有==index.val的节点链接的起点的假头部，为了处理方便而设
        // plast是所有>index.val的节点链接的终点
        while (head != last) {
            if (head.val < index.val) {
                ppre.next = head;
                head = head.next;
                ppre = ppre.next;
            } else if (head.val == index.val) {
                ListNode temp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = temp;
            } else {
                plast.next = head;
                plast = plast.next;
                head = head.next;
            }
        }

        ppre.next = dummy.next;
        plast.next = last;

        helper(pre, pre.next, dummy.next);
        helper(index, index.next, last);
    }
}
