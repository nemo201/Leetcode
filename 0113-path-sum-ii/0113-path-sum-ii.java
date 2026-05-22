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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, ans, new ArrayList());
        return ans;
    }

    private void helper(TreeNode node, int k, List<List<Integer>> ans, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == k) {
                ans.add(new ArrayList<>(list));
            }
        }
        helper(node.left, k - node.val, ans, list);
        helper(node.right, k - node.val, ans, list);

        list.remove(list.size() - 1);
    }
}