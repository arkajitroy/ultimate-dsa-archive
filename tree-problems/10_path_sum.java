import java.util.LinkedList;
import java.util.Queue;
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

class Pair<K, V> {
    private final K key;
    private final V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}

// using the DFS Traversal

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        // The main edge case is target-sum (remaining should be equal to the root.val);
        if(root.left == null && root.right == null) return targetSum == root.val;

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}

// Level Order Traversal

class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        // initially putting the root and path
        path.push(root);
        sumPath.push(root.val);

        while (!path.isEmpty()) {
            TreeNode node = path.pop();
            int currentSum = sumPath.pop();

            if(node.left == null && node.right == null && currentSum == targetSum) return true;

            if(node.left != null){
                path.push(node.left);
                sumPath.push(node.left.val + currentSum);
            }

            if(node.right != null){
                path.push(node.right);
                sumPath.push(node.right.val + currentSum);
            }
        }
        return false;
    }
}


// Traversal: BFS

class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, root.val));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int sum = current.getValue();

            // if its a leaf node and the sum matches
            if(node.left == null && node.right == null && sum == targetSum) return true;

            if(node.left != null){
                queue.offer(new Pair<>(node.left, sum + node.left.val));
            }
            if(node.right != null){
                queue.offer(new Pair<>(node.right, sum + node.right.val));
            }
        }
        return false;
    }
}