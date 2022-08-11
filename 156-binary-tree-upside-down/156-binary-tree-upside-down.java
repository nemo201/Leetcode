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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        return helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null || node.left == null) {
            return node;
        }
        
        TreeNode root = helper(node.left);
        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;
        
        return root;
    }
}