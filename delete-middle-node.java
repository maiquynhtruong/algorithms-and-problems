/** Delete the middle node of a singly linked list, given only that middle node**/
/** Solution: Copy the next node over to the current node, then delete the next node **/

public class Solution {
    public ListNode deleteMiddle(ListNode middle) {
        ListNode cur = middle;
        while (cur.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
        }
        cur = null;
    }
    
    public ListNode deleteMiddleBetter(ListNode middle) {
        if (middle == null || middle.next == null) return null;
        ListNode next = middle.next;
        middle.val = next.val;
        middle.next = next.next;
        return middle;
    }
    public static void main(String args[]) [
        
    }

}
