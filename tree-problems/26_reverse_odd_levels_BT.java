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

// Approach: DFS recursive
// complexity: O(n) | O(h)

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        compute(root.left, root.right, 1);
        return root;
    }
    private void compute(TreeNode left, TreeNode right, int level){
        if(left == null || right == null) return;

        // If the level is odd, then perform the swap
        if(level % 2 == 1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        // perform the recursion for the next levels
        compute(left.left, right.right, level+1);
        compute(left.right, right.left, level+1);
    }
}

// Approach: BFS
// complexity: O(n) | O(n)

class Solution2 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Collect nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // If it's an odd level, reverse the values
            if (level % 2 == 1) {
                int i = 0, j = currentLevelNodes.size() - 1;
                while (i < j) {
                    int temp = currentLevelNodes.get(i).val;
                    currentLevelNodes.get(i).val = currentLevelNodes.get(j).val;
                    currentLevelNodes.get(j).val = temp;
                    i++;
                    j--;
                }
            }

            level++;
        }

        return root;
    }
}