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
    int preOrderIndex;
    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return arrToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        
        int val = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(val);
        
        root.left = arrToTree(preorder, left, map.get(val) - 1);
        root.right = arrToTree(preorder, map.get(val) + 1, right);
        
        return root;
    }
}