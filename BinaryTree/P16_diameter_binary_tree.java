package BinaryTree;

class Main{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private static int dfs(TreeNode root){
        if(root == null) return maxDiameter;

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Binary tree (Brute-Force) : " + diameterOfBinaryTree(root));
    }
}

/*
// ================================ (Brute Force) - O(n^2)
    public static int diameterOfBinaryTree_BF(TreeNode root){
        if(root == null) return 0;

        int diameterThroughRoot = height_BF(root.left) + height_BF(root.right);
        int diameterLeftST = diameterOfBinaryTree_BF(root.left);
        int diameterRightST = diameterOfBinaryTree_BF(root.right);

        int maxSubtree = Math.max(diameterLeftST, diameterRightST);

        return Math.max(diameterThroughRoot, maxSubtree);
    }

    private static int height_BF(TreeNode root){
        if(root == null) return 0;

        int leftHeight = height_BF(root.left);
        int rightHeight = height_BF(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

*/