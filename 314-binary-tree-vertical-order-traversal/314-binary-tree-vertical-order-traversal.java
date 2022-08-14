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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null)
            return ans;
        
        Map<Integer, List<Integer>> colTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int col = 0;
        q.offer(new Pair(root, col));
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            root = p.getKey();
            col = p.getValue();
            
            if (!colTable.containsKey(col)) {
                colTable.put(col, new ArrayList());
            }
            colTable.get(col).add(root.val);
            
            if (root.left != null)
                q.offer(new Pair(root.left, col - 1));
            if (root.right != null)
                q.offer(new Pair(root.right, col + 1));
        }
        List<Integer> sorted = new ArrayList(colTable.keySet());
        Collections.sort(sorted);
        
        for (int k : sorted)
            ans.add(colTable.get(k));
        
        return ans;
    }
}