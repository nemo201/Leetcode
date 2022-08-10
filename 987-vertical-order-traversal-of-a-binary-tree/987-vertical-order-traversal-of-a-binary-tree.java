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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] == b[0])
                    return Integer.compare(a[2], b[2]);
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        helper(root, 0, 0, q);
        
        while (!q.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int[] node = q.poll();
            layer.add(node[2]);
            while (!q.isEmpty() && q.peek()[1] == node[1]) {
                int[] tmp = q.poll();
                layer.add(tmp[2]);
            }
            ans.add(layer);
        }
        return ans;
    }
    
    private void helper(TreeNode node, int row, int col, Queue<int[]> q) {
        if (node == null)
            return;
        helper(node.left, row + 1, col - 1, q);
        q.offer(new int[]{row, col, node.val});
        helper(node.right, row + 1, col + 1, q);
    }
}