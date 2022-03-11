/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head)
            return NULL;
        ListNode* fast = head, *slow = head;
        int size = 1;
        
        while (fast->next) {
            fast = fast->next;
            size++;
        }
        
        for (int i = size - k % size; i > 1; i--)
            slow = slow->next;
        
        fast->next = head;
        head = slow->next;
        slow->next = NULL;
        
        return head;
    }
};