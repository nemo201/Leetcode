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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(p);
        qu.offer(q);
        
        while (!qu.isEmpty()) {
            TreeNode one = qu.poll();
            TreeNode two = qu.poll();
            
            if (one == null && two == null)
                continue;
            
            if (one == null || two == null)
                return false;
            
            if (one.val != two.val)
                return false;
            qu.offer(one.left);
            qu.offer(two.left);
            qu.offer(one.right);
            qu.offer(two.right);
        }
        return true;
    }
}