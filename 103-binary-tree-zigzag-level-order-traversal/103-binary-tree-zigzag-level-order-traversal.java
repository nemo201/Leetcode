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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean even = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
                
                if (even) {
                    curLevel.add(curNode.val);
                } else 
                    curLevel.addFirst(curNode.val);
            }
            ans.add(curLevel);
            even = !even;
        }
        return ans;
    }
}