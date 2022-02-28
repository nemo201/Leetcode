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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    int height(TreeNode root) {
        if (root == null)
            return 0;
        int h1 = height(root.left);
        int h2 = height(root.right);
        int diff = Math.abs(h1 - h2);
        
        if (h1 >= 0 && h2 >= 0 && diff < 2)
            return Math.max(h1, h2) + 1;
        
        return -1;
    }
}