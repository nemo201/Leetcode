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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    private int dfs(TreeNode node, List<List<Integer>> ans) {
        if (node == null)
            return -1;
        int level = 1 + Math.max(dfs(node.left, ans), dfs(node.right, ans));
        
        if (ans.size() < level + 1)
            ans.add(new ArrayList());
        
        ans.get(level).add(node.val);
        
        return level;
    }
}