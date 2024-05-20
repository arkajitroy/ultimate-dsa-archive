package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // This Queue will store the Node info according to level
    static class QueueNodeInfo {
        TreeNode node;
        int horizontalDistance;

        QueueNodeInfo(TreeNode nodeValue, int levelValue){
            this.node = nodeValue;
            this.horizontalDistance = levelValue;
        }
    }

    public static void topView(TreeNode root){
        if (root == null) return;

        HashMap<Integer, Integer> viewMap = new HashMap<>();
        Queue<QueueNodeInfo> queue = new LinkedList<>();
        queue.add(new QueueNodeInfo(root, 0));

        while (!queue.isEmpty()) {
            QueueNodeInfo current = queue.poll();
            int horizontalDistance = current.horizontalDistance;
            TreeNode node = current.node;

            if (!viewMap.containsKey(horizontalDistance)) {
                viewMap.put(horizontalDistance, node.val);
            }

            if (node.left != null) {
                queue.add(new QueueNodeInfo(node.left, horizontalDistance - 1));
            }

            if (node.right != null) {
                queue.add(new QueueNodeInfo(node.right, horizontalDistance + 1));
            }
        }

        viewMap.keySet().stream().sorted().forEach(key -> {
            System.out.print(" " + viewMap.get(key));
        });
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.println("Top View of Binary Tree:");
        topView(root);
    }
}