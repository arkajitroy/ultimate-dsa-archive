package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class QueueNodeInfo {
        TreeNode node;
        int horizontalDistance;

        QueueNodeInfo(TreeNode nodeValue, int levelValue){
            this.node = nodeValue;
            this.horizontalDistance = levelValue;
        }
    }

    public static void bottomView(TreeNode root){
        if(root == null) return;

        HashMap<Integer, Integer> bottomViewMap = new HashMap<>();
        Queue<QueueNodeInfo> queue = new LinkedList<>();
        queue.add(new QueueNodeInfo(root, 0));

        while (!queue.isEmpty()) {
            QueueNodeInfo current = queue.poll();
            int horizontalDistance = current.horizontalDistance;
            TreeNode node = current.node;

            // Replace the value fo the horizontal-distance
            bottomViewMap.put(horizontalDistance, node.val);

            if(node.left != null) queue.add(new QueueNodeInfo(node.left, horizontalDistance - 1));
            if(node.right != null) queue.add(new QueueNodeInfo(node.right, horizontalDistance + 1));
        }

        bottomViewMap.keySet().stream().sorted().forEach(key -> {
            System.out.print(" "+bottomViewMap.get(key));
        });
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Bottom View of the Binary Tree");
        bottomView(root);
    }
}
