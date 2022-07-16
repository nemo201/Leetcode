/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
    
    private boolean helper(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null)
            return false;
        
        int left = helper(curNode.left, p, q) ? 1 : 0;
        int right = helper(curNode.right, p, q) ? 1 : 0;
        
        int mid = (curNode == p || curNode == q) ? 1 : 0;
        
        if (mid + left + right >= 2)
            ans = curNode;
        
        return (mid + left + right > 0);
    }
}