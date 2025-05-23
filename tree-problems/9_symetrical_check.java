import java.util.LinkedList;
import java.util.Queue;

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

// Approach: DFS Recursive
// Complexity: O(n) | O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2){
        // checking for edge cases
        if(t1 == null && t2 == null) return true;
        if(t1 == null && t2 == null) return false;

        // So there will 3 checkings 
        // 1. check for the root node
        // 2. subRoot.left == subRoot.right (direction will be different)
        // 3. subRoot.right == subRoot.left (direction will be differnt)
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

// Approach: BFS

class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        // putting the initial node to the queue
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            // 1. checking for the root node
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null || t1.val != t2.val) return false;

            // Mirror check: outer and inner pairs
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        
        return true;
    }
}