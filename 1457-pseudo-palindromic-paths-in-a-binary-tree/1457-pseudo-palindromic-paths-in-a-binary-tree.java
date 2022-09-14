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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodes = new HashSet();
        helper(root, nodes);
        return ans;
    }
    
    private void helper(TreeNode node, Set<Integer> nodes) {
        if (node == null)
            return;
        
        if (nodes.contains(node.val))
            nodes.remove(node.val);
        else
            nodes.add(node.val);
        
        if (node.left == null && node.right == null)
            if (nodes.size() <= 1)
                ans++;
        helper(node.left, nodes);
        helper(node.right, nodes);
        
        if (nodes.contains(node.val))
            nodes.remove(node.val);
        else
            nodes.add(node.val);
    }
}