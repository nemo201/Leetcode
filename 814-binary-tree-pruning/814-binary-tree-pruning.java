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
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }
    
    private TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;
        
        node.left = dfs(node.left);
        
        node.right = dfs(node.right);
        
        if (node.val == 0 && node.left == null && node.right == null)
            node = null;
        
        return node;
    }
}