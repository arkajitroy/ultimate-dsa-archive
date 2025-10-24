import java.util.*;

/**
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal arrays, construct and return the binary tree.
 */

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
* Approach 1: Recursive (Brute Force)
* For each root, we search its index in inorder[] using a linear scan.
* Time Complexity: O(n²) — for each node we may search the inorder array.
* Space Complexity: O(n) — recursion stack + output tree.
*/
class Solution {  
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the root in inorder traversal (O(n) scan)
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        int leftTreeSize = rootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}


/**
 * Approach 2: Optimized Recursive using HashMap
 * Preprocessing inorder[] to store each value’s index helps achieve O(1) lookups.
 *
 * Time Complexity: O(n) — each node processed once.
 * Space Complexity: O(n) — hashmap + recursion stack.
 */
class Solution2 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) return null;

        // Precompute indices of inorder values for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inorderRootIndex - inStart;

        // Recursively construct left and right subtrees
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inStart);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, inorderRootIndex + 1);

        return root;
    }
}
