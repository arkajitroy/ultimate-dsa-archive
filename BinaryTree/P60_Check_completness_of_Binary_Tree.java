package BinaryTree;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isCompleteTree(TreeNode root){
        int nodeCount = countNodes(root);
        return isComplete(root, 1, nodeCount);
    }

    private static int countNodes(TreeNode node){
        if (node == null) return 0;
        int leftSubtree = countNodes(node.left);
        int rightSubtree = countNodes(node.right);
        return 1 + leftSubtree + rightSubtree;
    }

    private static boolean isComplete(TreeNode node, int index, int nodeCount){
        if (node == null) return true;

        // Check if the current node's index is greater than the total number of nodes
        if (index > nodeCount) return false;

        // Recursively check the left and right subtrees
        boolean leftSubtreeCompleteness = isComplete(node.left, 2 * index, nodeCount);
        boolean rightSubtreeCompleteness = isComplete(node.right, 2 * index + 1, nodeCount);

        return leftSubtreeCompleteness && rightSubtreeCompleteness;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        boolean result = isCompleteTree(root);
        System.out.println("Is the tree complete? " + result);
    }
}
