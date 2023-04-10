/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        dfs(root, ans);
        
        return ans;
    }
    
    public void dfs(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;
        
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }
}