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
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root, null);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
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
                TreeNode node = q.poll();
                seen.add(node);
                if (node.left != null && !seen.contains(node.left)) {
                    seen.add(node.left);
                    q.offer(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    seen.add(node.right);
                    q.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (par != null && !seen.contains(par)) {
                    seen.add(par);
                    q.offer(par);
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