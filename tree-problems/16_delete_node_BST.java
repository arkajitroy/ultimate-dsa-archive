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

// Approach: using the recursive way
// complexity: O(n) | O(1)

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Find the key node in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // Find the key node in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // Node found
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node has two children
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}

// Approach: using the itterative way
// complexity: O(n) | O(1)

class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode current = root;

        // Step 1: Search for the node
        while (current != null && current.val != key) {
            parent = current;
            if (key < current.val)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) return root; // key not found

        // Step 2: Delete the node

        // Case 1: Node has two children
        if (current.left != null && current.right != null) {
            TreeNode successorParent = current;
            TreeNode successor = current.right;

            // Find the inorder successor
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.val = successor.val; // Copy successor's value
            current = successor;
            parent = successorParent;
        }

        // Now current has at most 1 child
        TreeNode child = (current.left != null) ? current.left : current.right;

        if (parent == null) {
            // Deleting the root node
            return child;
        }

        if (parent.left == current) parent.left = child;
        else parent.right = child;

        return root;
    }
}