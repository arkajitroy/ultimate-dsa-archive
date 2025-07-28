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

// Approach: Moris Traversal
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Check for swapped nodes
                if (prev != null && prev.val > current.val) {
                    if (first == null) first = prev;
                    second = current;
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;

                    // Check for swapped nodes
                    if (prev != null && prev.val > current.val) {
                        if (first == null) first = prev;
                        second = current;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }

        // Swap the values of the two nodes
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

// Approach: Recursive Inorder Traversal 
// Time Complexity: O(n)
// Space Complexity: O(h) : h is the height of the tree

class Solution3 {
    TreeNode first = null, second = null;
    TreeNode previous = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        computeInorder(root);
        // performing the swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void computeInorder(TreeNode node){
        if(node == null) return;

        computeInorder(node.left);
        // validation: previousNode > currentNode
        if(previous.val > node.val){
            if(first == null) first = previous;
            second = node;
        }
        previous = node;
        computeInorder(node.right);
    }
}