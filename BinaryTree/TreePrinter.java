package BinaryTree;

import BinaryTree.P34_construct_binary_tree.TreeNode;

public class TreePrinter {
    // Static method to print the tree structure
    public static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        printTree(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.val);
        } else {
            System.out.println(root.val);
        }
        printTree(root.left, level + 1);
    }
}
