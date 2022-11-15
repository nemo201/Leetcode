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
    public int countNodes(TreeNode root) {
    if (root == null)
        return 0;
        
        int d = computeDepth(root);
        
        if (d == 0)
            return 1;
        
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        
        while (left <= right) {
            pivot = left + (right - left) / 2;
            
            if (exists(pivot, d, root))
                left = pivot + 1;
            else
                right = pivot - 1;
        }
        return (int)Math.pow(2, d) - 1 + left;
  }
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null){
            node = node.left;
            d++;
        }
        return d;
    }
    
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        
        for (int i = 0; i < d; i++) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot){
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
}