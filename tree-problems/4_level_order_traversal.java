import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//Approach 1: Iterative BFS (Using Queue)
// Time Complexity: O(N)
// Space Complexity: O(N)
// This approach traverses level by level using a queue (classic level order).

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add child nodes for the next level
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            levels.add(currentLevel);
        }
        return levels;
    }
}

// Approach 2: Recursive DFS (Using Depth Tracking)
// Time Complexity: O(N)
// Space Complexity: O(H), where H = height of tree (due to recursion stack)

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;

        // Create a new level list if we are visiting this depth for the first time
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }

        // Add the node value to its corresponding depth level
        result.get(depth).add(node.val);

        // Recurse for left and right subtrees
        traverse(node.left, depth + 1, result);
        traverse(node.right, depth + 1, result);
    }
}
