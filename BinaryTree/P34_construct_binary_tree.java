package BinaryTree;

import java.util.HashMap;
import java.util.Map;
import BinaryTree.TreePrinter;

class P34_construct_binary_tree {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;

        Map<Integer, Integer> nodeMap = new HashMap<>(); // hashing all the node values
        for(int i=0; i<inorder.length; i++){
            nodeMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1, nodeMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> nodeMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRootIndex = nodeMap.get(root.val);
        int leftSubtreeSize = inorderRootIndex - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, inorderRootIndex - 1, nodeMap);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, inorderRootIndex + 1, inEnd, nodeMap);
        
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode binaryTree = buildTree(preorder, inorder);
        System.out.println("Binary Tree\n");
        TreePrinter.printTree(binaryTree, 0);
    }
}
