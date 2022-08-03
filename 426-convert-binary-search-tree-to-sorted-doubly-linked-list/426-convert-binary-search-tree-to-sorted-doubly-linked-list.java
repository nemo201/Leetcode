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
    List<Node> ans = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        
        helper(root);
        //List<Node> ans = new LinkedList<>();
        ans.get(0).left = ans.get(ans.size() - 1);
        
        for (int i = 0; i < ans.size() - 1; i++) {
            ans.get(i).right = ans.get(i + 1);
        }
        ans.get(ans.size() - 1).right = ans.get(0);
        
        for (int i = ans.size() - 1; i > 0; i--) {
            ans.get(i).left = ans.get(i - 1);
        }
        return ans.get(0);
    }
    
    private void helper(Node node) {
        if (node == null)
            return;
        helper(node.left);
        ans.add(node);
        helper(node.right);
    }
}