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
    vector<int> vec;
    bool isUnivalTree(TreeNode* root) {
        
        dfs(root);
        
        for (int v : vec) {
            if (v != vec[0])
                return false;
        }
        return true;
    }
    
    void dfs(TreeNode* root) {
        if (root) {
            vec.push_back(root->val);
            dfs(root->left);
            dfs(root->right);
        }
    }
};