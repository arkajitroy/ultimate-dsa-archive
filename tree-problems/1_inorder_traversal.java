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

// Apprach: Recursive
// Complexity: O(n) | O(h)

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

// Approach : Iterative - Stack based
// Complexity: O(n) | O(h)

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