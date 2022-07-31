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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(original);
        q.offer(cloned);
        
        while (!q.isEmpty()) {
            TreeNode o = q.poll();
            TreeNode c = q.poll();
            
            if (o == target)
                return c;
            if (o.left != null){
                q.offer(o.left);
                q.offer(c.left);
            }
            if (o.right != null) {
                q.offer(o.right);
                q.offer(c.right);
            }
        }
        return null;
    }
}