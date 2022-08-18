/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node last = null, first = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        
        first.left = last;
        last.right = first;
        return first;
    }
    
    private void dfs(Node node) {
        if (node == null)
            return;
        dfs(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        dfs(node.right);
    }
}