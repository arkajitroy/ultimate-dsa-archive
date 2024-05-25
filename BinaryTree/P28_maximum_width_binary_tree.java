import java.util.LinkedList;
import java.util.Queue;

class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int firstIndex = 0, lastIndex = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int currentIndex = pair.index - minIndex;  // Normalize the index

                if (i == 0) firstIndex = currentIndex;
                if (i == size - 1) lastIndex = currentIndex;

                if (node.left != null) queue.offer(new Pair(node.left, 2 * currentIndex + 1));
                if (node.right != null) queue.offer(new Pair(node.right, 2 * currentIndex + 2));
            }
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println("Maximum Width of Binary Tree: " + widthOfBinaryTree(root)); // Output: 4
    }
}
