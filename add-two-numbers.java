// https://leetcode.com/problems/add-two-numbers/

class Solution {
    // public class ListNode {
    // int val;
    // ListNode next;
    // ListNode(int x) { val = x; }
    // }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode l1 = list1, l2 = list2;
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            cur.next = new ListNode((sum) % 10);
            carry = sum / 10;
            if (l1 != null) l1 = l1.next; 
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        if (carry > 0) 
            cur.next = new ListNode(carry);
        return result.next;
    }
}
