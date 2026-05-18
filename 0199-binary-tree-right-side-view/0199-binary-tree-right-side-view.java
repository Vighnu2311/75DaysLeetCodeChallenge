import java.util.*;

// Definition for binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        // Final answer list
        List<Integer> result = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return result;
        }

        // Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root node
        queue.offer(root);

        // Run until queue becomes empty
        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int size = queue.size();

            // Traverse current level
            for (int i = 0; i < size; i++) {

                // Remove node from queue
                TreeNode current = queue.poll();

                // If this is the last node in this level
                if (i == size - 1) {
                    result.add(current.val);
                }

                // Add left child
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}