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
    public int closestValue(TreeNode root, double target) {
        int val, ans = root.val;
        while (root != null) {
            val = root.val;
            ans = Math.abs(val - target) < Math.abs(ans - target) ? val : ans;
            root = target < root.val ? root.left : root.right;
        }
        return ans;
    }
}