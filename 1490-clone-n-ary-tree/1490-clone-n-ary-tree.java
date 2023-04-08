/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneTree(Node root) {
        if (root == null)
            return null;
        return dfs(root);
    }
    
    public Node dfs(Node node) {
        if (map.containsKey(node))
            return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        for (Node nei : node.children) {
            copy.children.add(dfs(nei));
        }
        return copy;
    }
}