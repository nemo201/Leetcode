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
    int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return ans;
    }
    
    boolean dfs(TreeNode node) {
        if (node.left == null && node.right == null){
            ans++;
            return true;
        }
        boolean isUni = true;
        
        if (node.left != null)
            isUni = dfs(node.left) && isUni && node.left.val == node.val;
        
        if (node.right != null)
            isUni = dfs(node.right) && isUni && node.right.val == node.val;
        
        if (!isUni)
            return false;
        ans++;
        return true;
    }
}