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
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length - 1;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, inorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right)
            return null;
        
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        
        root.right = arrayToTree(postorder, map.get(val) + 1, right);
        root.left = arrayToTree(postorder, left, map.get(val) - 1);
                
        return root;
    }
}