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
    TreeNode x = null, y = null, prev = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(x, y);
    }
    
    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left);
        if (prev != null && node.val < prev.val) {
            y = node;
            if (x == null)
                x = prev;
            else
                return;
        }
        prev = node;
        helper(node.right);
    }
    
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}