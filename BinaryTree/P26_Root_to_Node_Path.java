package BinaryTree;

import java.util.ArrayList;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> rootToNode(TreeNode start, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        if (start == null) return result;
        getPathToNode(start, target, result);
        return result;
    }

    private static boolean getPathToNode(TreeNode start, int target, ArrayList<Integer> result) {
        if (start == null) return false;
        result.add(start.val);

        // If we found the target node, return true
        if (start.val == target) return true;

        // Recursively check the left and right subtrees
        if (getPathToNode(start.left, target, result) || getPathToNode(start.right, target, result)) {
            return true;
        }

        // If the target is not found, remove the current node from the path and return false
        result.remove(result.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        ArrayList<Integer> result = rootToNode(root, 6);
        System.out.println("Node Path: " + result);
    }
}
