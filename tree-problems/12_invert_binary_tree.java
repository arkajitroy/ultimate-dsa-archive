import java.util.LinkedList;
import java.util.Queue;

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

// Approach: Recursion
// complexity: O(n) | O(h)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}

// Approach: Iterative BFS (Level order) + queue
// complexity: O(n) | O(n)

class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // swapping left and right nodes
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }

        return root;
    }
}