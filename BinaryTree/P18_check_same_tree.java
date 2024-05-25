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

    public static boolean isSameTree(TreeNode tree_a, TreeNode tree_b) {
        if (tree_a == null && tree_b == null) return true;
        if (tree_a == null || tree_b == null) return false;

        boolean leftTraversal = isSameTree(tree_a.left, tree_b.left);
        boolean rightTraversal = isSameTree(tree_a.right, tree_b.right);

        return (tree_a.val == tree_b.val) && leftTraversal && rightTraversal;
    }

    public static void main(String[] args) {
        TreeNode tree_1 = new TreeNode(1);
        tree_1.left = new TreeNode(2);
        tree_1.right = new TreeNode(3);
        tree_1.right.left = new TreeNode(4);
        tree_1.right.right = new TreeNode(5);

        TreeNode tree_2 = new TreeNode(1);
        tree_2.left = new TreeNode(2);
        tree_2.right = new TreeNode(3);
        tree_2.right.left = new TreeNode(4);
        tree_2.right.right = new TreeNode(5);

        System.out.println("Both Trees are same ?: " + isSameTree(tree_1, tree_2));
    }
}
