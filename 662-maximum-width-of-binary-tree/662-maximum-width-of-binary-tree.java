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
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        return dfs(root, 1, 0, left);
    }
    
    private int dfs(TreeNode root, int id, int d, List<Integer> left) {
        if (root == null)
            return 0;
        if (d >= left.size())
            left.add(id);
        return Math.max(id + 1 - left.get(d), Math.max(dfs(root.left, id*2, d+1, left), dfs(root.right, id*2 + 1, d+1, left)));
    }
}