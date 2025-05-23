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

class Solution {
    static class NodeWithIndex {
        TreeNode node;
        int index;

        NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxWidth = 0;
        Queue<NodeWithIndex> queue = new LinkedList<>();
        queue.offer(new NodeWithIndex(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftMost = 0, rightMost = 0;            
            int minIndex = queue.peek().index;

            for (int i = 0; i < size; i++) {
                NodeWithIndex current = queue.poll();
                int index = current.index - minIndex;  // normalize index to avoid overflow

                if (i == 0) leftMost = index;
                if (i == size - 1) rightMost = index;

                if (current.node.left != null){
                    queue.offer(new NodeWithIndex(current.node.left, 2 * index));
                }
                if (current.node.right != null){
                    queue.offer(new NodeWithIndex(current.node.right, 2 * index + 1));
                }   
            }
            maxWidth = Math.max(maxWidth, rightMost - leftMost + 1);
        }
        return maxWidth;
    }
}

// DFS-approach

class Solution2 {
    private int maxWidth = 0;
    private Map<Integer, Integer> leftmostAtDepth = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode node, int depth, int index) {
        if (node == null) return;

        // Store the first (leftmost) index at each depth
        leftmostAtDepth.putIfAbsent(depth, index);

        int currentWidth = index - leftmostAtDepth.get(depth) + 1;
        maxWidth = Math.max(maxWidth, currentWidth);

        dfs(node.left, depth + 1, 2 * index);
        dfs(node.right, depth + 1, 2 * index + 1);
    }
}
