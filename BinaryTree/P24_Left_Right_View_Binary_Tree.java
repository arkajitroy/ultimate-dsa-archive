package BinaryTree;

import java.util.ArrayList;
import java.util.List;

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

    public static void leftAndRightViewBinaryTree(TreeNode root){
        TreeNode leftTraversalRoot = root;
        TreeNode rightTraversalRoot = root;

        List<Integer> leftView = new ArrayList<Integer>();
        List<Integer> rightView = new ArrayList<Integer>();

        leftViewTraversal(leftTraversalRoot, leftView, 0);
        rightViewTraversal(rightTraversalRoot, rightView, 0);

        System.out.println("Left View : " + leftView);
        System.out.println("Right View : " + rightView);
    }

    private static void rightViewTraversal(TreeNode current, List<Integer> result, int depth){   
        if(current == null) return;
        if(depth == result.size()) result.add(current.val);
        //recursively traverse
        rightViewTraversal(current.right, result, depth+1);
        rightViewTraversal(current.left, result, depth+1);
    }

    private static void leftViewTraversal(TreeNode current, List<Integer> result, int depth){  
        if(current == null) return;
        if(depth == result.size()) result.add(current.val);
        //recursively traverse
        leftViewTraversal(current.left, result, depth+1); 
        leftViewTraversal(current.right, result, depth+1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        leftAndRightViewBinaryTree(root);
    }
}
