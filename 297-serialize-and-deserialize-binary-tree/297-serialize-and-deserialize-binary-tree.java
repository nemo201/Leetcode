/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "X,";
        String leftST = serialize(root.left);
        String rightST = serialize(root.right);
        return root.val + "," + leftST + rightST;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }
    private TreeNode deserializeHelper(Queue<String> nodesRemaining) {
        String current = nodesRemaining.poll();
        if (current.equals("X")) return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(current));
        newNode.left = deserializeHelper(nodesRemaining);
        newNode.right = deserializeHelper(nodesRemaining);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));