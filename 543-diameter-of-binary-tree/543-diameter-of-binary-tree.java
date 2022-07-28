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
    int dia;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        helper(root);
        return dia;
    }
    
    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        
        dia = Math.max(dia, left + right);
        
        return Math.max(left, right) + 1;
    }
}