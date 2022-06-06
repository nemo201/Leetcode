/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        
        ListNode d1 = headA, d2 = headB;
        while (d1 != d2) {
            d1 = d1 == null ? headA : d1.next;
            d2 = d2 == null ? headB : d2.next;
        }
        return d1;
    }
}