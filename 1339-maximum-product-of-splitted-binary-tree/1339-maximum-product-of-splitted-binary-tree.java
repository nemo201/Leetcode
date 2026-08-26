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
    private long totalSum;
    private long maxProduct;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        dfs(root);
        return (int)(maxProduct % 1_000_000_007);
    }

    private long getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long subtreeSum = node.val + dfs(node.left) + dfs(node.right);

        long otherSum = totalSum - subtreeSum;

        long product = subtreeSum * otherSum;

        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}