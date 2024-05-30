package BinaryTree;

import java.util.Stack;

class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if(k == 0) return current.val;
            current = current.right;
        }
        return -1;
    }

    public static int kthLargest(TreeNode root, int k){
        if(root == null) return -1;
        TreeNode start = null, end = null;

        while (k > 0) {
            start = root;
            end = root.right;

            // if there is no right, it means we are at the largest element
            if(end == null){
                k--;
                root = root.left;
                continue;
            }

            while (end.left != null) {
                end = end.left;
            }

            // rewiring to root
            end.left = start;

            root = root.right;
            start.right = null;
        }
        return start.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int smallest_target = 3, largest_target = 2;

        System.out.println("Smallest "+smallest_target+" Element => " + kthSmallest(root, smallest_target));
        System.out.println("Largest "+largest_target+" Element => " + kthLargest(root, largest_target));
    }
}


/* ================================================== (using Moris Traversal - O(n) O(1)) =============================
 * class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;

        while(current != null){
            if(current.left == null){
                count++;
                if(count == k) return current.val;
                current = current.right;
            }
            else{
                TreeNode predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) predecessor = predecessor.right;

                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right = null;
                    count++;
                    if(count == k) return current.val;
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
 */