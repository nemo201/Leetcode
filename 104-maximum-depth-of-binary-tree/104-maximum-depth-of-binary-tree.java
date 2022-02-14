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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int depth = 1;
        
        while (q.size() > 1) {
            TreeNode curr = q.poll();
            if (curr == null) {
                q.add(null);
                depth++;
                continue;
            }
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return depth;
    }
}