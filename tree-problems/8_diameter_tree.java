class TreeNode {
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

// Optimal Approach: O(n) | O(1)

class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        compute(root);
        return diameter;
    }

    private int compute(TreeNode root){
        if(root == null) return 0;

        int leftHeight = compute(root.left);
        int rightHeight = compute(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}


// BRUTE FORCE APPROACH : O(n ^ 2) | O(n)

class Solution2 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        compute(root);
        return diameter;
    }

    private void compute(TreeNode root){
        if(root == null) return;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        compute(root.left);
        compute(root.right);
    }

    private int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(
            getHeight(root.left), getHeight(root.right)
        );
    }
}