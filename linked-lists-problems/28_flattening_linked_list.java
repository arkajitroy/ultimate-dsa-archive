import java.util.*;

class Node {
    int val;
    Node next;
    Node bottom;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next, Node bottom) { this.val = val; this.next = next; this.bottom = bottom; }
}


// Priorty Queue - min heap
class Solution2{
    Node flatten(Node root){
        if(root == null) return null;

        // Building a min-heap for storing the head
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val
        );

        // inserting all the head nodes into heap
        Node temp = root;
        while(temp != null){
            pq.offer(temp);
            temp = temp.next;
        }

        Node dummy = new Node(0);
        Node current = dummy;

        // extracting minimum elements
        while (!pq.isEmpty()) {
            Node headNode = pq.poll(); // taking the smallest node
            current.bottom = new Node(headNode.val); // appending to result
            current = current.bottom;

            // If the extracted node has a bottom node (next in its vertical list),
            // push it to the heap so we continue merging sorted lists
            if(headNode.bottom != null) pq.offer(headNode.bottom);
        }
        return dummy.bottom;
    }
}

// Brute Force approach
class Solution3 {
    Node flatten(Node root) {
        List<Integer> values = new ArrayList<>();
        
        // collecting all the values
        Node temp = root;
        while (temp != null) {
            Node current = temp;
            while(current != null){
                values.add(current.val);
                current = current.bottom;
            }
            temp = temp.next;
        }

        // sort the collected values
        Collections.sort(values);

        // creating a new list
        Node dummy = new Node(0);
        Node current = dummy;

        for(int val : values){
            current.bottom = new Node(val);
            current = current.bottom;
        }

        return dummy.bottom;
    }
}