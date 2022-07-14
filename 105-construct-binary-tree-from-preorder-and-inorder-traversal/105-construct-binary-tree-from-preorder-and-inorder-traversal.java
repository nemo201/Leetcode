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
    Map<Integer, Integer> inIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length -1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        
        root.left = arrayToTree(preorder, left, inIndex.get(val) - 1);
        root.right = arrayToTree(preorder, inIndex.get(val) + 1, right);
        
        return root;
    }
}