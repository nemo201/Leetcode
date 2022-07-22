/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode p2 = head;
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        ListNode greater = new ListNode(0);
        ListNode grt = greater;
        
        while (p2 != null) {
            if (p2.val < x) {
                ptr.next = p2;
                ptr = ptr.next;
            } else {
                grt.next = p2;
                grt = grt.next;
            }
            p2 = p2.next;
        }
        grt.next = null;
        if (greater.next != null)
            ptr.next = greater.next;
        
        return dummy.next;
    }
}