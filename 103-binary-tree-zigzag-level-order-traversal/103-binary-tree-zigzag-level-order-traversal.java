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
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean even = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                
                if (even) {
                    curLevel.add(node.val);
                } else {
                    curLevel.addFirst(node.val);
                }
            }
            even = !even;
            ans.add(curLevel);
        }
        return ans;
    }
}