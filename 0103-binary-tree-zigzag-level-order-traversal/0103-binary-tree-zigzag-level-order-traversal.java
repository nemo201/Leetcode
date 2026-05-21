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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder =  new LinkedList<>();
        level(root, 0, levelOrder);
        return levelOrder;
    }

    private void level(TreeNode node, int depth, List<List<Integer>> level) {
        if (node == null) {
            return;
        }

        if (level.size() == depth) {
            List<Integer> list = new LinkedList<>();
            list.add(node.val);
            level.add(list);
        } else {
            if (depth % 2 == 0) {
                level.get(depth).add(node.val);
            } else {
                level.get(depth).addFirst(node.val);
            }
        }

        level(node.left, depth + 1, level);
        level(node.right, depth + 1, level);
    }
}