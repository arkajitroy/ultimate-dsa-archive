// 105. Construct Binary Tree from Preorder and Inorder Traversal


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

// Approach: Recursive
// Complexity : O(n^2) and O(n)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) return null;
        return buildTree( preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = -1;

        for(int i=inStart; i<= inEnd; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int leftTreeSize = rootIndex - inStart;
        // int rightTreeSize = inEnd - rootIndex;

        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}

// Approach: Recursive
// Complexity : O(n) and O(n)

class Solution2 {
    // MAP< value, index >
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) return null;

        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i); // store the index of inorder elements in a map
        }

        return buildTree(preorder, 0, preorder.length-1, 0);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart){
        if(preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = inorderIndexMap.get(rootVal);
        int leftSubtreeSize = rootIndexInorder - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, inStart);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, rootIndexInorder + 1);

        return root;
    }
}