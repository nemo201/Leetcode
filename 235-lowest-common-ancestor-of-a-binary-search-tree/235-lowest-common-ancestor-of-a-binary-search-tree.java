/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(true) {
            if (p.val < cur.val && q.val < cur.val)
                cur = cur.left;
            else if (p.val > cur.val && q.val > cur.val)
                cur = cur.right;
            else
                break;
        }
        return cur;
    }
}


// if (p.val < root.val && q.val < root.val)
//             return lowestCommonAncestor(root.left, p, q);
//         if (p.val > root.val && q.val > root.val)
//             return lowestCommonAncestor(root.right, p, q);
        
//         return root;