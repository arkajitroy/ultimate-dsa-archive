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


// Approach: Iterative - stack based
// Complexity: O(n) | O(h) - where h is the height of the tree
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Push right first so that left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        
        return result;
    }
}


// Approach: Recursive
// Complexity: O(n) | O(h)

class Solution2{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        compute(root, result);
        return result;
    }

    private void compute(TreeNode node, List<Integer> result){
        if(node == null) return;

        result.add(node.val);
        compute(node.left, result);
        compute(node.right, result);
    }
}