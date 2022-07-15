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
        
        Node leftmost = root;
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                head.left.next = head.right;
                
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}

// O(n) space
// class Solution {
//     public Node connect(Node root) {
//         if (root == null)
//             return null;
        
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);
        
//         while (!q.isEmpty()) {
//             int size = q.size();
            
//             for (int i = 0; i < size; i++) {
//                 Node node = q.poll();
//                 if (i < size - 1)
//                     node.next = q.peek();
                
//                 if (node.left != null)
//                     q.offer(node.left);
                
//                 if (node.right != null)
//                     q.offer(node.right);
//             }
//         }
//         return root;
//     }
// }