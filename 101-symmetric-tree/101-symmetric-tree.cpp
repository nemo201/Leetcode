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
    bool isSymmetric(TreeNode* root) {
        if (!root) return true;
		queue<TreeNode*> pending({ root->left, root->right });

		while (!pending.empty())
		{
			TreeNode* l = pending.front();
			pending.pop();
			TreeNode* r = pending.front();
			pending.pop();

			if (!l && r || l && !r) return false;
			if (l)
			{
				if (l->val != r->val) return false;
				pending.push(l->left);
				pending.push(r->right);
				pending.push(l->right);
				pending.push(r->left);
			}
		}

		return true;
    }
};