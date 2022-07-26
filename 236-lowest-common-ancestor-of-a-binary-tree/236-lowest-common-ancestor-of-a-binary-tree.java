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
    TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return this.ans;
    }
    
    private boolean recurseTree(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null)
            return false;
        
        int left = recurseTree(curNode.left, p, q) ? 1 : 0;
        
        int right = recurseTree(curNode.right, p, q) ? 1: 0;
        
        int mid = (curNode == p || curNode == q) ? 1 : 0;
        
        if (mid + left + right >= 2)
            ans = curNode;
        
        return (mid + left + right > 0);
    }
}