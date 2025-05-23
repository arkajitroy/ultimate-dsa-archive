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

class Pair{
    TreeNode node;
    int hd; // horizontal-distance
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    static ArrayList<Integer> topView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode curr = pair.node;
            int hd = pair.hd;

            // Only insert if this HD is not already present
            hdMap.putIfAbsent(hd, curr.val);

            if (curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if (curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
        return new ArrayList<>(hdMap.values());
    }
}