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
        List<List<Integer>> result = new ArrayList<>();
        helper (root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void helper (TreeNode node, int target, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == target) {
                result.add(new ArrayList<>(list));
            }
        }

        helper (node.left, target - node.val, result, list);
        helper (node.right, target - node.val, result, list);

        list.remove(list.size() - 1);
    }
}