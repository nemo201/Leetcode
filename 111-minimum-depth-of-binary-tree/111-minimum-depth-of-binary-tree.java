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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null)
            return 1;
        
        int min_Depth = Integer.MAX_VALUE;
        if (root.left != null)
            min_Depth = Math.min(min_Depth, minDepth(root.left));
        if (root.right != null)
            min_Depth = Math.min(min_Depth, minDepth(root.right));
        
        return min_Depth + 1;
    }
}