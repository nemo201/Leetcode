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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        
        average(root, 0, ans, count);
        
        for (int i = 0; i < ans.size(); i++)
            ans.set(i, ans.get(i) / count.get(i));
        return ans;
    }
    
    private void average(TreeNode node, int i, List<Double> ans, List<Integer> count) {
        if (node == null)
            return;
        if (i < ans.size()) {
            ans.set(i, ans.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            ans.add(1.0*node.val);
            count.add(1);
        }
        average(node.left, i + 1, ans, count);
        average(node.right, i + 1, ans, count);
    }
}