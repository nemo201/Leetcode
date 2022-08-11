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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
    private boolean helper(TreeNode node) {
        if (node == null)
            return true;
        if (!helper(node.left))
            return false;
        if (prev != null && node.val <= prev)
            return false;
        prev = node.val;
        return helper(node.right);
    }
}