package BinaryTree;

class Main{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        // checking for null case
        if(root == null) return null;
        while (root != null) {
            if(root.val == val) return root;
            root = (val < root.val) ? root.left : root.right;
        }

        // if the key is not found
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println("Element in BST : " + searchBST(root, 40).val);
    }
}