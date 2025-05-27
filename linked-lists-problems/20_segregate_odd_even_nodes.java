class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}

// Approach: using pointers
// complexity: O(n) | O(1)

class Solution {
    Node divide(Node head) {
        if (head == null || head.next == null) return head;

        Node evenStart = new Node(0);
        Node oddStart = new Node(0);

        Node even = evenStart, odd = oddStart;
        Node curr = head;

        while (curr != null) {
            // checking the node value is even or odd
            if (curr.val % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }

        even.next = oddStart.next; 
        odd.next = null;

        return evenStart.next; 
    }
}