import java.util.*;

// Reusable Treenode class
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        compute(root, result);
        return result;
    }

    private void compute(TreeNode node, List<Integer> result){
        if(node == null) return;

        // calling the function recursively
        compute(node.left, result);
        result.add(node.val);
        compute(node.right, result);
    }
}

// Approach-2: Itterative Approach (using stack)
// Time Complexity: O(n)
// Space Complexity: O(s) | s = size of the stack
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while( root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}