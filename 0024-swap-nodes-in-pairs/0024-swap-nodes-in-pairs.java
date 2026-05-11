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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true) {
            ListNode knode = getkthNode(prevGroup);
            if (knode == null) {
                break;
            }
            ListNode nextFront = knode.next;
            ListNode cur = prevGroup.next;
            ListNode prev = nextFront;

            for (int i = 0; i < 2; i++) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode temp = prevGroup.next;
            prevGroup.next = knode;
            prevGroup = temp;
        }
        return dummy.next;
    }
    private ListNode getkthNode(ListNode cur) {
        int k = 2;
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}