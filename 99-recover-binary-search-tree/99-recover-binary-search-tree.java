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
    TreeNode x = null, y = null, pred = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(x, y);
    }
    
    private void helper(TreeNode node) {
        if (node == null)
            return;
        helper(node.left);
        if (pred != null && node.val < pred.val) {
            y = node;
            if (x == null) {
                x = pred;
            } else
                return;
        }
        pred = node;
        helper(node.right);
    }
    
    private void swap(TreeNode a, TreeNode b) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}