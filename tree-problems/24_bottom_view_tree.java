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
    public ArrayList<Integer> bottomView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Map<Integer, Integer> hdMap = new TreeMap<>(); // Map<line-no, node>
        Queue<Pair> queue = new LinkedList<>(); // Queue<node, line-node>

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode curr = pair.node;
            int hd = pair.hd;

            // overwrite value at this HD
            hdMap.put(hd, curr.val);

            if (curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if (curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }

        return new ArrayList<>(hdMap.values());
    }
}