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
    TreeNode x = null, y = null, z = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(x, y);
    }
    
    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left);
        if (z != null && node.val < z.val) {
            y = node;
            if (x == null)
                x = z;
            else
                return;
        }
        z = node;
        helper(node.right);
    }
    
    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}