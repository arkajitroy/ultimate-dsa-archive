import java.util.Stack;

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

// Optimal Approach : Moris Traversal
// TC: O(n) | O(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode currentNode = root;
        int count = 0;

        while (currentNode != null) {
            // Condition-1: no left child, process the node.val and move to right
            if(currentNode.left == null){
                count++;
                if(count == k) return currentNode.val;
                currentNode = currentNode.right;
            }
            // Condition-2: has a left child, find the inorder predecessor
            else{
                TreeNode predecessor = currentNode.left;
                // move to right most node of the left subtree - inorder predecessor
                while (predecessor.right != null && predecessor.right != currentNode) {
                    predecessor = predecessor.right;
                }

                // Creating a temporary thread and continue traversal as follows
                if(predecessor.right != null){
                    predecessor.right = currentNode;
                    currentNode = currentNode.left;
                }
                // Case: Thread already exists, proceed further traversal and delete the link
                else{
                    predecessor.right = null;
                    count++;
                    if(count == k) return currentNode.val;

                    // Moving to the right subtree
                    currentNode = currentNode.right;
                }
            }
        }
        // k is invalid if this point is reached
        return -1;
    }
}

// Better Approach 1: recursive inorder search
// TC: O(n) | O(h)
class Solution2 {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        computeInorder(root, k);
        return result;
    }

    private void computeInorder(TreeNode root, int k){
        if(root == null || count >= k) return;

        // recursively calling the inorder function
        // compute for the left subtree
        computeInorder(root.left, k);
        // compute for data node
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        // compute for the right subtree
        computeInorder(root.right, k);
    }
}

// Better Approach: Iterative inorder using stack
// TC: O(h + k) | O(S) || S: size of the stack 

class Solution3{
    Stack<TreeNode> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        while (true) {
            // 1. Go to left as possible and traverse
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // pop from the stack and check wheather it is kth element or not
            root = stack.pop();
            k--;
            if(k == 0) return root.val;

            // 3. Traverse to the rightward side
            root = root.right;
        }
    }
}