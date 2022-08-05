/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        int dist = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode n : q)
                    ans.add(n.val);
                return ans;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                seen.add(cur);
                if (cur.left != null && !seen.contains(cur.left)) {
                    seen.add(cur.left);
                    q.offer(cur.left);
                }
                if (cur.right != null && !seen.contains(cur.right)) {
                    seen.add(cur.right);
                    q.offer(cur.right);
                }
                TreeNode par = parent.get(cur);
                if (par != null && !seen.contains(par)){
                    q.offer(par);
                    seen.add(par);
                }
            }
            dist++;
        }
        return new ArrayList<Integer>();
    }
    
    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    } 
}