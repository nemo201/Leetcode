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
    List<Integer> list = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == low) {
                while (list.get(i) != high) {
                    ans += list.get(i);
                    i++;
                }
                ans += high;
            }
        }
        return ans;
    }
    
    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}