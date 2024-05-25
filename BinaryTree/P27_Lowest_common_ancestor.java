package BinaryTree;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode point, TreeNode destination) {
        if (root == null || root == point || root == destination) return root;

        TreeNode left = lowestCommonAncestor(root.left, point, destination);
        TreeNode right = lowestCommonAncestor(root.right, point, destination);

        if (left == null) return right;
        if (right == null) return left;
        
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = createTestTree();
        TreeNode point = root.left.left; // Node with value 4
        TreeNode destination = root.left.right.right; // Node with value 7
        
        TreeNode result = lowestCommonAncestor(root, point, destination);
        System.out.println("Lowest Common Ancestor : " + (result != null ? result.val : "None"));
    }

    private static TreeNode createTestTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        root.right = new TreeNode(3, new TreeNode(8), new TreeNode(9));
        return root;
    }
}
