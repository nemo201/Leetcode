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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        Stack<TreeNode []> stk = new Stack<>();
        stk.push(new TreeNode[]{root1, root2});
        while (!stk.isEmpty()) {
            TreeNode[] t = stk.pop();
            if (t[0] == null || t[1] == null)
                continue;
            
            t[0].val += t[1].val;
            if (t[0].left == null)
                t[0].left = t[1].left;
            else
                stk.push(new TreeNode[]{t[0].left, t[1].left});
            
            if (t[0].right == null)
                t[0].right = t[1].right;
            else
                stk.push(new TreeNode[]{t[0].right, t[1].right});
        }
        return root1;
    }
}