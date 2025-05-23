// 104. Maximum Depth of Binary Tree | Height of the binary tree

import java.util.*;

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

// Approach: BFS
// Complexity : O(n) | O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root); // initially adding the root node

        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}

// Approach: DFS - Recursion
// Complexity : O(n) | O(h) - h is the height of the tree stack

class Solution2 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}