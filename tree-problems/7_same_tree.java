// 100. Same Tree

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

// Approach : Recursive - DFS

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Approach: Interative BFS
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if(node1.val != node2.val) return false;

            if(node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            } else if(node1.left != null || node2.left != null) {
                return false;
            }

            if(node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
            } else if(node1.right != null || node2.right != null) {
                return false;
            }
        }
        return true;
    }
}