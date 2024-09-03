package LinkedLists;

import java.util.HashSet;

class P14_detect_cycle_linked_list {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    // APPROACH 01: using HashSet - O(n) | O(n)
    public static boolean hasCycle_Better(Node head){
        HashSet<Node> visited = new HashSet<>();
        Node current = head;

        while (current != null) {
            if(visited.contains(current)) return true;
            visited.add(current);
            current = current.next; // increasing the pointer
        }
        return false;
    }

    // APPROACH 02: using tow pointers - O(n) | O(1)
    public static boolean hasCycle(Node head){
        if (head == null || head.next == null) return false;

        // assigning slow and fast pointers
        Node slow = head, fast = head.next;

        while (slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
    }
}
