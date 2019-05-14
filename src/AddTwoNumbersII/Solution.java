package AddTwoNumbersII;

import java.util.Stack;

class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tmp;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int num1 = !s1.isEmpty() ? s1.pop() : 0;
            int num2 = !s2.isEmpty() ? s2.pop() : 0;

            int sum = num1 + num2 + carry;

            carry = sum >= 10 ? sum / 10 : 0;

            tmp = dummy.next;
            dummy.next = new ListNode(sum % 10);
            dummy.next.next = tmp;
        }

        return dummy.next;
    }
}
