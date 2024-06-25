package BinaryTree;

import java.util.Stack;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int sum = 0;

    // Recursive approach - O(n) | O(h) : h -> recursive stack space
    public static TreeNode bstToGreaterSum_recursion(TreeNode root){
        if(root != null){
            bstToGreaterSum_recursion(root.right); // going to extreme right node
            sum += root.val; // adding up the node val
            root.val = sum;// adding the value to root node
            bstToGreaterSum_recursion(root.left); // going to left node
        }
        return root;
    }

    public static TreeNode bstToGreaterSum_stack(TreeNode root){
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);


    }
}
