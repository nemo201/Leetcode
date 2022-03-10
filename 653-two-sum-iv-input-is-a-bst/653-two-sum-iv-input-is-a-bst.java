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
    TreeNode root;
    public boolean findTarget(TreeNode node, int k) {
        if (root == null)
            root = node;
        if (node == null)
            return false;
        
        if (search(node, k - node.val))
            return true;
        
        return findTarget(node.left, k) || findTarget(node.right, k);
    }
    
    public boolean search(TreeNode node, int k) {
        TreeNode cur = root;
        while (cur != null) {
            if (k > cur.val)
                cur = cur.right;
            else if (k < cur.val)
                cur = cur.left;
            else
                return cur != node ? true : false;
        }
        return false;
    }
}