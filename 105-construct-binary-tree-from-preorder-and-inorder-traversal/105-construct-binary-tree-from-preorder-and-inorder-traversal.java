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
    int preIndex;
    Map<Integer, Integer> location = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++)
            location.put(inorder[i], i);
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] pre, int left, int right) {
        if (left > right)
            return null;
        int val = pre[preIndex++];
        TreeNode root = new TreeNode(val);
        
        root.left = helper(pre, left, location.get(val) - 1);
        root.right = helper(pre, location.get(val) + 1, right);
        
        return root;
    }
}