package BinaryTree;

// Balance Binary Tree: for Every Node - height(left) - height(right) <= 1

class Main {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isBalanced(TreeNode root){
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode root){
        if(root == null) return 0;

        // check for left-subtree-height
        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;
        // check for right-subtree-height
        int rightHeight = dfs(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(3);

        System.out.println("Tree is balanced ? " + isBalanced(root));
    }
}
