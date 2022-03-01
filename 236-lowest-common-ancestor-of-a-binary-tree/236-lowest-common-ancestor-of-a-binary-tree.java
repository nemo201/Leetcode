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
    
    private boolean dfs(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null)
            return false;
        
        int left = dfs(curNode.left, p, q) ? 1 : 0;
        int right = dfs(curNode.right, p, q) ? 1 : 0;
        
        int mid = (curNode == p || curNode == q) ? 1 : 0;
        
        if (mid + left + right >= 2)
            ans = curNode;
        
        return (mid + left + right > 0);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}