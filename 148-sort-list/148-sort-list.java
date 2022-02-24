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
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        Collections.sort(list);
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        for (int i = 0; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            ret.next = newNode;
            ret = ret.next;
        }
        return dummy.next;
    }
}