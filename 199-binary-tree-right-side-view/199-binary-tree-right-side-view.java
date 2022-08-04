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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return ans;
        dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode node, int level) {
        if (node == null)
            return;
        if (ans.size() == level)
            ans.add(node.val);
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}