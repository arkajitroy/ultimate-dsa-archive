import java.util.*;

/**
 * Problem: 104. Maximum Depth of Binary Tree
 * Goal: Find the maximum depth (height) of a binary tree.
 */

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/**
* Approach 1: Iterative BFS (Level Order Traversal)
* We traverse level by level using a queue and count how many levels exist.
*
* Time Complexity: O(n)  — Every node is visited once.
* Space Complexity: O(n) — Queue holds up to one level of nodes at a time.
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++; // one level deeper

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return depth;
    }
}


/**
 * Approach 2: Recursive DFS
 * We explore both left and right subtrees and return the larger depth.
 * Time Complexity: O(n) — Each node is visited once.
 * Space Complexity: O(h) — Recursion stack (h = height of the tree).
 */

class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Height of tree = 1 (current node) + max depth of left/right subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
