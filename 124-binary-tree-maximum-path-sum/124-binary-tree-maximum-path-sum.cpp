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
    int maxVal = INT_MIN;
    
    int maxPathSum(TreeNode* root) {
        helper(root);
        return maxVal;
    }
    
    int helper(TreeNode* root) {
        if (!root)
            return 0;
        
        int left = max(helper(root->left), 0);
        int right = max(helper(root->right), 0);
        
        maxVal = max(maxVal, root->val + left + right);
        
        return root->val + max(left, right);
    }
};