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
class Solution 
{
public:
    ListNode* deleteDuplicates(ListNode* head) 
    {
        if(head==NULL or head->next==NULL)
            return head;
        
        ListNode* ans = new ListNode(0,head);
        ListNode* prev = ans;
        
        while(head)
        {
            if(head->next != NULL && head->val == head->next->val)
            {
                while(head->next != NULL && head->val == head->next->val)
                {
                    head = head->next;
                }
                prev->next = head->next;
            }
            else
            {
                prev = prev->next;     
            }
            head = head->next;
        }
        return ans->next;            
    }
};