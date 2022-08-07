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
        
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int col = 0;
        q.offer(new Pair(root, col));
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            root = p.getKey();
            col = p.getValue();
            
            if (root != null) {
                if (!columnTable.containsKey(col))
                    columnTable.put(col, new ArrayList());
                columnTable.get(col).add(root.val);
                
                q.offer(new Pair(root.left, col - 1));
                q.offer(new Pair(root.right, col + 1));
            }
        }
        List<Integer> sortedKeys = new ArrayList<>(columnTable.keySet());
        Collections.sort(sortedKeys);
        
        for (int k : sortedKeys)
            ans.add(columnTable.get(k));
        
        return ans;
    }
}