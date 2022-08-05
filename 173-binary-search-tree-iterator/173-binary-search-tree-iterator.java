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
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index;

    public BSTIterator(TreeNode root) {
        index = -1;
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    
    public int next() {
        return list.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */