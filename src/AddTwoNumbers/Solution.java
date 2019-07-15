package AddTwoNumbers;

import Common.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode it1 = l1;
        ListNode it2 = l2;
        ListNode curr = dummyHead;
        int carry = 0;

        while (it1 != null || it2 != null) {
            int n1 = 0;
            int n2 = 0;

            if (it1 != null) {
                n1 = it1.val;
                it1 = it1.next;
            }

            if (it2 != null) {
                n2 = it2.val;
                it2 = it2.next;
            }

            int sum = n1 + n2 + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
