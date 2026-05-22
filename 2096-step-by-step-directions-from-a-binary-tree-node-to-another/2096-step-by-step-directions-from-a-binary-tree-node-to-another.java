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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(lca, startValue, startPath);
        findPath(lca, destValue, destPath);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < startPath.length(); i++) {
            ans.append('U');
        }
        ans.append(destPath);
        return ans.toString();
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        path.append('L');
        if (findPath(node.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(node.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}