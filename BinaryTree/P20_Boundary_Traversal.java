package BinaryTree;

import java.util.ArrayList;

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

    public static ArrayList<Integer> boundaryTraversal (TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root != null){
            result.add(root.val);
            leftBoundaryTraversal(root.left, result);
            leavesTraversal(root.left, result);
            leavesTraversal(root.right, result);
            rightBoundaryTraversal(root.right, result);
        }
        return result;
    }

    private static void leftBoundaryTraversal(TreeNode root, ArrayList<Integer> result){
        if(root != null){
            if(root.left != null){
                result.add(root.val);
                leftBoundaryTraversal(root.left, result);
            }
            else if(root.right != null){
                result.add(root.val);
                leftBoundaryTraversal(root.right, result);
            }
        }
    }

    private static void rightBoundaryTraversal(TreeNode root, ArrayList<Integer> result){
        ArrayList<Integer> temp = new ArrayList<>();
        while (root != null) {
            if (root.left != null || root.right != null) {
                temp.add(root.val);
            }
            root = (root.right != null) ? root.right : root.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private static void leavesTraversal(TreeNode root, ArrayList<Integer> result){
        if(root != null){
            leavesTraversal(root.left, result);
            if(root.left == null && root.right == null) result.add(root.val);
            leavesTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println("Boundary Traversal of Binary Tree: " + boundaryTraversal(root));
    }
}
