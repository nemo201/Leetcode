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
    TreeNode* root;
    bool findTarget(TreeNode* node, int k) {
        if (!root)
            root = node;
        if (!node)
            return false;
        
        if (search(node, k - node->val))
            return true;
        
        return findTarget(node->left, k) || findTarget(node->right, k);
    }
    
    bool search(TreeNode* node, int k) {
        TreeNode* cur = root;
        while (cur) {
            if (k > cur->val)
                cur = cur->right;
            else if (k < cur->val)
                cur = cur->left;
            else
                return cur != node ? true : false;
        }
        return false;
    }
};