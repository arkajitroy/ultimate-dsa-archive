package LinkedLists;

import java.util.HashMap;
import java.util.Map;

class P27_clone_LL_with_random_pointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head){
        if(head == null) return null;

        // creating a hashmap to store mapping between original nodes
        Map<Node, Node> map = new HashMap<>();

        // first pass: copy all the nodes to map
        Node current = head; // pointer
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // second pass : assign the next and random pointers
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        // return the head
        return map.get(head);
    }

    // OPTIMAL APPROACH: without using extra space
    public static Node copyRandomList_OP(Node head){
        if(head == null) return null;

        // Step 1: Create a copy of each node and insert it right next to the original node.
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes.
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Restore the original list and extract the copied list.
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node newHead = head.next;
        Node copy = newHead;
        
        while (current != null) {
            current.next = copy.next;
            current = current.next;
            if(current != null){
                copy.next = current.next;
                copy = copy.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.random = head.next.next; // 1 -> 3
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next; // 4 -> 2
        head.next.next.next.next.random = head; // 5 -> 1

        Node copyList = copyRandomList(head);

    }
}
