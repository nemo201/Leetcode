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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return arrToTree(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode arrToTree(int[] pre, int left, int right) {
        if (left > right)
            return null;
        int rootval = pre[preIndex++];
        TreeNode root = new TreeNode(rootval);
        
        root.left = arrToTree(pre, left, map.get(rootval) - 1);
        root.right = arrToTree(pre, map.get(rootval) + 1, right);
        
        return root;
    }
}