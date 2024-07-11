package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<TreeNode> findDuplicateSubtree(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();
        serializeTree(root, subtreeMap, result);
        return result;
    }

    public static String serializeTree(TreeNode node, Map<String, Integer> subtreeMap, List<TreeNode> result){
        if(node == null) return "#";
        String serializedLeftSubtree = serializeTree(node.left, subtreeMap, result);
        String serializedRightSubtree = serializeTree(node.right, subtreeMap, result);
        String serialized = node.val + "," + serializedLeftSubtree + "," + serializedRightSubtree;
        
        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);

        if(subtreeMap.get(serialized) == 2) result.add(node);

        return serialized;
    }

    public static void printTree(List<TreeNode> list){
        for(TreeNode node : list){
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        System.out.println("Duplicate Subtree");
        printTree(findDuplicateSubtree(root));
    }
}
