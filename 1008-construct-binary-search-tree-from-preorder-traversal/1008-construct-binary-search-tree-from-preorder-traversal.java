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
    int nodeId = 0;
    public TreeNode bstFromPreorder(int[] pre) {
        if (pre == null || pre.length == 0)
            return null;
        return helper(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode helper(int[] pre, int start, int end) {
        if(nodeId == pre.length || pre[nodeId] < start || pre[nodeId] > end)
            return null;
        
        int val = pre[nodeId++];
        TreeNode node = new TreeNode(val);
        node.left = helper(pre, start, val);
        node.right = helper(pre, val, end);
        return node;
    }
}