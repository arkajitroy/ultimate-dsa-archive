package BinaryTree;

import java.util.Stack;

public class P69_Path_sum {

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
    public static boolean hasPathSum_BEST(TreeNode root, int targetSum) {
        if(root == null) return false;

        // create 2 stacks for the path and the sums
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        // traversing the tree
        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sumPath.pop();

            if(temp.left == null && temp.right == null && tempVal == targetSum) return true;
            
            if(temp.right != null){
                path.push(temp.right);
                sumPath.push(temp.right.val + tempVal);
            }

            if(temp.left != null){
                path.push(temp.left);
                sumPath.push(temp.left.val + tempVal);
            }
        }

        return false;
    }


    // Recursive DFS Approach
    public static boolean hasPathSum(TreeNode root, int targetSum) {
       if(root == null) return false;
       if(root.left==null && root.right==null) return targetSum == root.val;
       
       boolean leftsum=hasPathSum(root.left,targetSum-root.val);
       boolean rightsum=hasPathSum(root.right,targetSum-root.val);

       return leftsum||rightsum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        System.out.println("Valid Path Sum : " + hasPathSum(root, targetSum));
    }
}
