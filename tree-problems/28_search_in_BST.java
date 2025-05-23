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

// Approach: using recursion
// complexity: O(n) | O(h)

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}

// Approach: usign iterative
// complexity: O(n) | O(1)

class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        while (root != null) {
            if(root.val == val) return root;
            root = (val < root.val) ? root.left : root.right;
        }

        return null;
    }
}