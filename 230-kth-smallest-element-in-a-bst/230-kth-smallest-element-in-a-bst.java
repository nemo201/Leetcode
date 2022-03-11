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
    int kthSmallest(TreeNode* root, int k) {
        vector<int> vec;
        inorder(root, vec);
        
        return vec[k-1];
    }
    
    vector<int> inorder(TreeNode* root, vector<int>& vec) {
        if (!root)
            return vec;
        inorder(root->left, vec);
        vec.push_back(root->val);
        return inorder(root->right, vec);
    }
};