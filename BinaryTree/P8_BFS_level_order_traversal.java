package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        // checking for the edge-cases
        if(root == null) return wrapList;
        queue.offer(root);

        // traversing the whole tree
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> numsGroupList = new LinkedList<Integer>();
            for(int i=0; i<level; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                numsGroupList.add(queue.poll().val);
            }
            wrapList.add(numsGroupList);
        }

        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Level Order Traversal: " + levelOrderTraversal(root));
    }
}