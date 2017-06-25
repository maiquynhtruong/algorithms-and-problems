public class Solution {
    public static void partition(ListNode cur, int x) {
        ListNode before = new ListNode();
        ListNode after = new ListNode();
        ListNode bPointer = before, aPointer = after;
        ListNode xNode = null;
        while (cur != null) {
            if (cur.val == x) xNode = cur;
            else if (cur.val < x) { bPointer.next = cur; bPointer = bPointer.next; }
            else {aPointer.next = cur; aPointer = aPointer.next; }
            cur = cur.next;
        }
        if (xNode != null) { bPointer.next = xNode; bPointer = bPointer.next; }
        bPointer.next = after;
        return before;
    }
    
    public static void PartitionShorter(ListNode head, int x) {
        ListNode cur = head, tail;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (cur.val < x) {
                cur.next = head;
                head = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            cur = curNext;
        }
        tail.next = null;
        return head;
    }

    public static void main(String args[]) {
        
    }

}
