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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();
   
        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }
        
        Collections.sort(l);
        
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        for (int i : l) {
            ListNode newNode = new ListNode(i);
            ptr.next = newNode;
            ptr = ptr.next;
        }
        
        ptr.next = null;
        return head.next;
    }
}