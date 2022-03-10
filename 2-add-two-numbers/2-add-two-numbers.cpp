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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode nextNode = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int p = (l1 != null) ? l1.val : 0;
            int q = (l2 != null) ? l2.val : 0;
            
            int sum = carry + p + q;
            carry = sum / 10;
            
            nextNode.next = new ListNode(sum % 10);
            nextNode = nextNode.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry != 0)
            nextNode.next = new ListNode(carry);
        
        return dummy.next;
    }
}