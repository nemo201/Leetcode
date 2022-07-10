/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        Node leftNode = root;
        while (leftNode.left != null) {
            Node curNode = leftNode;
            while (curNode != null) {
                curNode.left.next = curNode.right;
                if (curNode.next != null) {
                    curNode.right.next = curNode.next.left;
                }
                curNode = curNode.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
}