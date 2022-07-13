/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}

// itterative
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
        
//         if (root == null)
//             return list;
        
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
        
//         while (!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> curLevel = new ArrayList();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();
//                 curLevel.add(node.val);
                
//                 if (node.left != null)
//                     q.offer(node.left);
                
//                 if (node.right != null)
//                     q.offer(node.right);
//             }
//             list.add(curLevel);
//         }
//         return list;
//     }
// }