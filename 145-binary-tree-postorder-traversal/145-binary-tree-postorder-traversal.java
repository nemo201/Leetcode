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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> sk = new Stack<>();
        TreeNode cur = root, prev = null;
        
        while (cur != null || !sk.isEmpty()) {
            while (cur != null) {
                sk.push(cur);
                cur = cur.left;
            }
            if (sk.peek().right == null || sk.peek().right == prev) {
                prev = sk.pop();
                list.add(prev.val);
            } else {
                cur = sk.peek().right;
            }
        }
        return list;
    }
}