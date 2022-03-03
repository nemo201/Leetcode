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
    int preIdx;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        
        root.left = arrayToTree(preorder, left, map.get(rootVal) - 1);
        root.right = arrayToTree(preorder, map.get(rootVal) + 1, right);
        return root;
    }
}