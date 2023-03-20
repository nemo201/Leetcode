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
    List<Integer> allSums = new ArrayList();
    
    public int maxProduct(TreeNode root) {
        long totalSum = treeSum(root);
        long best = 0;
        for (long sum : allSums)
            best = Math.max(best, sum * (totalSum - sum));
        
        return (int)(best % 1000000007);
    }
    
    private int treeSum(TreeNode subroot) {
        if (subroot == null)
            return 0;
        int leftSum = treeSum(subroot.left);
        int rightSum = treeSum(subroot.right);
        int totalSum = leftSum + rightSum + subroot.val;
        
        allSums.add(totalSum);
        return totalSum;
    }
}