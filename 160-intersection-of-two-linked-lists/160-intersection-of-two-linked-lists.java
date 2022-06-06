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
        int s1= 0, s2 = 0;
        ListNode p1 = headA, p2 = headB;
        
        while (p1 != null) {
            s1++;
            p1 = p1.next;
        }
        
        while (p2 != null) {
            s2++;
            p2 = p2.next;
        }
        
        p1 = headA;
        p2 = headB;
        
        while (s1 != s2) {
            if (s1 > s2) {
                p1 = p1.next;
                s1--;
            } else {
                p2 = p2.next;
                s2--;
            }
        }
        
        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return p1;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return null;
    }
}