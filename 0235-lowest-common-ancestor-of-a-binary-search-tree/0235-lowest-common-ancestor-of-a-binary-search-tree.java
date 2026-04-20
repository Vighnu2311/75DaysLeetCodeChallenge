class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // If both p and q are smaller → go left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater → go right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Split point → this is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}