package LinkedLists;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    //  Better Approach: O(2n) | O(1)
    public static Node removeNthFromEnd_better(Node head, int n){
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // special-case : removing the head
        if(length == n) return head.next;

        // second pass to find the node before the one we need to remove
        for(int i=1; i<length-n; i++){
            current = current.next;
        }

        // remove the node link
        current.next = current.next.next;
        return head;
    }

    // Optimal Approach : O(n) | O(1)
    public static Node removeNthFromEnd(Node head, int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        // move the first pointer n steps ahead
        for(int i=0; i<=n; i++){
            first = first.next;
        }

        // move the pointer together untill first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = removeNthFromEnd(head, 2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
