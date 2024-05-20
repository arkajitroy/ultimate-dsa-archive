package BinaryTree;

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

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root){
        maxPathSumHelper(root);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode root){
        if (root == null) return 0;

        int leftSubtreeSum = Math.max(maxPathSumHelper(root.left), 0);
        int rightSubtreeSum = Math.max(maxPathSumHelper(root.right), 0);

        maxSum = Math.max(maxSum, leftSubtreeSum + rightSubtreeSum + root.val);

        return Math.max(leftSubtreeSum, rightSubtreeSum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
