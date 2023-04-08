/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return dfs(node);
    }
    
    public Node dfs(Node node) {
        if (map.containsKey(node))
            return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        for (Node nei : node.neighbors)
            clone.neighbors.add(dfs(nei));
        
        return clone;
    }
}