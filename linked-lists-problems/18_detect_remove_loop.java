// Q. Remove loop in Linked List

// Similar questions is the detect a cycle in linked list - 2 (leetcode)

class Node {
    int data;
    Node next;
}

class Solution {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;
        
        // Detecting the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // Loop detected
        }

        if (slow != fast) return; // Loop not found!
        
        // Find the starting of the loop
        slow = head;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Move fast to last node of loop
        while (fast.next != slow) {
            fast = fast.next;
        }

        fast.next = null;
    }
}

