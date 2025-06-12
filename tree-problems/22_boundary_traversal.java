import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.data = val; }
    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if(node == null) return result;

        // adding the root node to the resultant list
        if(!isLeaf(node)) result.add(node.data);

        // we will do the anti-clock-wise traversal
        addLeftBoundary(node.left, result);
        addLeaves(node, result);
        addRightBoundary(node.right, result);

        return result;
    }

    private boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private void addRightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }

        // Add to result in reverse order
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
}