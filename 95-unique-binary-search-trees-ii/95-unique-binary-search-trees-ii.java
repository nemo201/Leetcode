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
    public LinkedList<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> alltrees = new LinkedList<TreeNode>();
        if (start > end) {
            alltrees.add(null);
            return alltrees;
        }
        
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left = helper(start, i - 1);
            LinkedList<TreeNode> right = helper(i + 1, end);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    alltrees.add(cur);
                }
            }
        }
        return alltrees;            
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return helper(1, n);
    }
}