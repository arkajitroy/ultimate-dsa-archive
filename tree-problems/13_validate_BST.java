import java.util.Stack;

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

// Approach: recursive
// complexity: O(n) | O(h)

class Solution {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return validate(root, min, max);
    }

    private boolean validate(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}

// Approach: iterative
// complexity: O(n) | O(n)

class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // traverse the left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // process the node
            current = stack.pop();

            if(current.val <= min || current.val >= max) return false;
            
            // updating the min and max values
            min = current.val;
            current = current.right;
        }

        return true;
    }
}