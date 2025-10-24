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

// Approach-1: Recursive approach (most common)
// Time Complexity: O(n)
// Space Complexity: O(t) | t = height of the binary tree

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        compute(root, result);
        return result;
    }

    private void compute(TreeNode node, List<Integer> result){
        if(node == null) return;

        compute(node.left, result);
        compute(node.right, result);
        result.add(node.val);
    }
}

// Approach-2: Itterative Approach (using stack)
// Time Complexity: O(n)
// Space Complexity: O(s) | s = size of the stack

class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Notice: push left first, so right is processed first
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);

        return result;
    }
}

