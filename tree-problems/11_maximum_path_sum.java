import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        computeSum(root);
        return maxSum;
    }

    private int computeSum(TreeNode node){
        if(node == null) return 0;

        int leftGain = Math.max(computeSum(node.left), 0);
        int rightGain = Math.max(computeSum(node.right), 0);

        // price of the current path (inc both right subchild)
        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}

// - ============================ 🔁 Followup Questions : Return the actual path ===========================

class FollowupSolution{
    private TreeNode maxNode = null;

    public List<Integer> getMaxPath(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if(maxNode == null) return path;

        List<Integer> leftPath = getSidePath(maxNode.left, true);
        List<Integer> rightPath = getSidePath(maxNode.right, true);

        // combine : leftpath + root + rightpath
        Collections.reverse(leftPath); // leftside bottom up approach

        path.addAll(leftPath);
        path.add(maxNode.val);
        path.addAll(rightPath);

        return path;
    }

    private List<Integer> getSidePath(TreeNode node, boolean gotPath){
        List<Integer> path = new ArrayList<>();

        while (node != null) {
            path.add(node.val);

            int leftGain = Math.max(getGain(node.left), 0);
            int rightGain = Math.max(getGain(node.right), 0);

            if(leftGain >= rightGain) node = node.left;
            else node = node.right;

            if(leftGain == 0 && rightGain == 0) break;
        }

        return path;
    }

    private int getGain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(getGain(node.left), 0);
        int right = Math.max(getGain(node.right), 0);
        return node.val + Math.max(left, right);
    }
}