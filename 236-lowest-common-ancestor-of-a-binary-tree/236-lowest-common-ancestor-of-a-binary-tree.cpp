/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* ans = NULL;
    
    bool dfs(TreeNode* curNode, TreeNode* p, TreeNode* q) {
        if (curNode == NULL)
            return false;
        
        int left = dfs(curNode->left, p, q) ? 1 : 0;
        int right = dfs(curNode->right, p, q) ? 1 : 0;
        
        int mid = (curNode == p || curNode == q) ? 1 : 0;
        
        if (mid + left + right >= 2)
            ans = curNode;
        
        return (mid + left + right > 0);
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, p, q);
        return ans;
    }
};