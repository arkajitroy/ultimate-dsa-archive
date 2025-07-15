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

// Approach: using the Recursive
// Complexity: O(log n) or O(n) | O(h)

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        // if value is less than current node, insert into left subtree
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        // if value is less than current node, insert into right subtree
        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

// Approach: using the Recursive
// Complexity: O(h) | O(1)

class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null) return newNode;

        TreeNode current = root;

        while (true) {
            if(val < current.val){
                if(current.left == null){
                    current.left = newNode;
                    break;
                }
                current = current.left;
            }
            else{
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }
}