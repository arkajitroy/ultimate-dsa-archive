import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// Approach: Level order Traversal
// Complexity: O(n) | O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node head = leftMost;

            while (head != null) {
                // Connect left -> right
                head.left.next = head.right;

                // Connect right -> next left
                if (head.next != null) head.right.next = head.next.left;

                head = head.next; // Move in the current level
            }
            leftMost = leftMost.left; // Move to next level
        }
        return root;
    }
}

// Approach: BFS Traversal
// Complexity: O(n) | O(Q) : size of the queue
class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            // Traversing the node only which are in the search space
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (prev != null) prev.next = curr;

                prev = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return root;
    }
}
