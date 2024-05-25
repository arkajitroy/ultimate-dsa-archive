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

    public static int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftSubtree = getHeightLeft(root);
        int rightSubtree = getHeightRight(root);

        if(leftSubtree == rightSubtree) return ((2 << (leftSubtree)) - 1);
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getHeightLeft(TreeNode root){
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private static int getHeightRight(TreeNode root){
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Total Node Counts in a complete binary tree : "+countNodes(root));
    }
}
