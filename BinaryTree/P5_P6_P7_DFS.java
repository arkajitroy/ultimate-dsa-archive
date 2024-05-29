package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main{
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

    // Iterative Inorder - Left, Root, Right
    public static List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            result.add(current.val);

            // Visit the right subtree
            current = current.right;
        }
        
        return result;
    }
    
    // Iterative Preorder - Root, Left, Right
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) return result;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // push the right child first if it is existing
            if(node.right != null) stack.push(node.right);
            // push the left child first if it is existing
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }

    // Iterative Postorder - Left, Right, Root
    public static List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return result;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> inorder_traversal = inOrder(root);
        List<Integer> preorder_traversal = preOrder(root);
        List<Integer> postorder_traversal = postOrder(root);

        System.out.println("Inorder Traversal : " + inorder_traversal);
        System.out.println("Preorder Traversal : " + preorder_traversal);
        System.out.println("Postorder Traversal : " + postorder_traversal);
    }
}