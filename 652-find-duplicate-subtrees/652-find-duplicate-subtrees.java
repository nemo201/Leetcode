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
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        post(root, map, ans);
        return ans;
    }
    
    private String post(TreeNode node, Map<String, Integer> map, List<TreeNode> ans) {
        if (node == null)
            return "#";
        String serial = node.val + "," + post(node.left, map, ans) + "," + post(node.right, map, ans);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}