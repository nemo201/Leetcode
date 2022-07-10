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
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                
                if (i < size - 1)
                    cur.next = q.peek();
                
                if (cur.left != null)
                    q.offer(cur.left);
                
                if (cur.right != null)
                    q.offer(cur.right);
            }
        }
        return root;
    }
}