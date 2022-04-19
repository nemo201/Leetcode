/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode *first = NULL, *second = NULL, *prev = NULL;
    void recoverTree(TreeNode* root) {
        swapval(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
    
    void swapval(TreeNode* curr) {
        if (!curr)
            return;
        swapval(curr->left);
        if (prev && prev->val > curr->val) {
            if (!first)
                first = prev;
            second = curr;
        }
        prev = curr;
        swapval(curr->right);
    }
};