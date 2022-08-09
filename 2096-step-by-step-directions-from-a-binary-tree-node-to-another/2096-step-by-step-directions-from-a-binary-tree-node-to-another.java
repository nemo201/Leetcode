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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        helper(root, startValue, s);
        helper(root, destValue, d);
        
        int i = 0, i_max = Math.min(s.length(), d.length());
        
        while (i < i_max && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            i++;
        
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }
    
    private boolean helper(TreeNode node, int val, StringBuilder sb) {
        if (node.val == val)
            return true;
        if (node.left != null && helper(node.left, val, sb))
            sb.append("L");
        else if (node.right != null && helper(node.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }
}