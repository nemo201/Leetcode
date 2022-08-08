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
        
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t))
                ans.add(t.val);
            if (t.left != null)
                t = t.left;
            else
                t = t.right;
        }
        addLeaves(ans, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t))
                s.push(t.val);
            if (t.right != null)
                t = t.right;
            else
                t = t.left;
        }
        while (!s.isEmpty())
            ans.add(s.pop());
        return ans;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    private void addLeaves(List<Integer> ans, TreeNode node) {
        if (isLeaf(node))
            ans.add(node.val);
        else {
            if (node.left != null)
                addLeaves(ans, node.left);
            if (node.right != null)
                addLeaves(ans, node.right);
        }
    }
}