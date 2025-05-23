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

// Recursive reverse preorder traversal
// complexity: O(n) | O(h)

// BFS will not work here as we need to traverse the tree in a specific order

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    public void rightView(TreeNode current, List<Integer> result, int currentDepth) {
        if(current == null) return;

        if(currentDepth == result.size()) result.add(current.val);

        rightView(current.right, result, currentDepth + 1);
        rightView(current.left, result, currentDepth + 1);
    }
}

// Left Side View

class Solution2 {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }
    public void leftView(TreeNode current, List<Integer> result, int currentDepth) {
        if(current == null) return;
        if(currentDepth == result.size()) result.add(current.val);

        leftView(current.left, result, currentDepth + 1);
        leftView(current.right, result, currentDepth + 1);
        
    }
}