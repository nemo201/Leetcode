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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        if (!isLeaf(root))
            ans.add(root.val);
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node))
                ans.add(node.val);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
        addLeaves(root, ans);
        Stack<Integer> s = new Stack<>();
        node = root.right;
        
        while (node != null) {
            if (!isLeaf(node))
                s.push(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        
        while (!s.empty())
            ans.add(s.pop());
        return ans;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    private void addLeaves(TreeNode node, List<Integer> ans) {
        if (isLeaf(node))
            ans.add(node.val);
        else {
            if (node.left != null)
                addLeaves(node.left, ans);
            if (node.right != null)
                addLeaves(node.right, ans);
        }
    }
}