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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> q_o = new ArrayDeque();
        q_o.offer(original);
        
        Deque<TreeNode> q_c = new ArrayDeque();
        q_c.offer(cloned);
        
        while (!q_o.isEmpty()) {
            TreeNode n_o = q_o.poll();
            TreeNode n_c = q_c.poll();
            
            if (n_o == target)
                return n_c;
            
            if (n_o.left != null) {
                q_o.offer(n_o.left);
                q_c.offer(n_c.left);
            }
            
            if (n_o.right != null) {
                q_o.offer(n_o.right);
                q_c.offer(n_c.right);
            }
        }
        return null;
    }
}