/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList();
        
        if (root == null)
            return ans;
        
        Queue<Node> q = new LinkedList();
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList();
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                Node n = q.poll();
                level.add(n.val);
                
                for (Node c : n.children)
                    q.offer(c);
            }
            ans.add(level);
        }
        return ans;
    }
}