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
        
        addLeaves(root, ans);
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
    
    private void addLeaves(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;
        
        if(isLeaf(node))
            ans.add(node.val);
        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }
}