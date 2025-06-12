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

// All the approach
// 1. Recursive + preorder traversal
// 2. Iterative using stack
// 3. Moris Traversal - (optimal)

// ==========================================================================

// 3. Approach: Moris Traversal
// complexity: O(n) | O(1)
class Solution1 {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if(current.left != null){
                TreeNode predecessor = current.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}

// 2. Approach: Recursive - preorder - storing previous pointer
// complexity: O(n) | O(h)
class Solution2 {
    public void flatten(TreeNode root) {
        if(root == null) return;

        // creating a stack and putting initial element in it
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

            if(!stack.isEmpty()) current.right = stack.peek();

            current.left = null;
        }
    }
}

// 1. Approach: Recursive - preorder - storing previous pointer
// complexity: O(n) | O(h)
class Solution3 {
    private TreeNode previous = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = previous;
        root.left = null;
        previous = root;
    }
}