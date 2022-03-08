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
    int idx = 0;
    TreeNode* bstFromPreorder(vector<int>& pre) {
        if (pre.size() == 0)
            return NULL;
        return helper(pre, INT_MIN, INT_MAX);
    }
    
    TreeNode* helper(vector<int>& pre, int start, int end) {
        if (idx == pre.size() || pre[idx] < start || pre[idx] > end)
            return NULL;
        
        int val = pre[idx++];
        TreeNode* node = new TreeNode(val);
        node->left = helper(pre, start, val);
        node->right = helper(pre, val, end);
        return node;
    }
};