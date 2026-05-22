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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode node, int target, int k) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (target == k + node.val) {
                return true;
            }
        }
        return helper(node.left, target, k + node.val) || helper(node.right, target, k + node.val);
    }
}