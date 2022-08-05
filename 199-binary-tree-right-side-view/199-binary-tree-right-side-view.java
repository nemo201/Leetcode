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
    List<Integer> rightView = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return rightView;
        helper(root, 0);
        return rightView;
    }
    
    private void helper(TreeNode node, int level) {
        if (node == null)
            return;
        if (rightView.size() <= level)
            rightView.add(node.val);
        helper(node.right, level + 1);
        helper(node.left, level + 1);
    }
}