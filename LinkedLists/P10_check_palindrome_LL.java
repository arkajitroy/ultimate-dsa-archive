package LinkedLists;

import java.util.Stack;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome_better(Node head) {
        if (head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        Node current = head;

        // push-all elements into the stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        // traversing the list again to compare the stack
        while (current != null) {
            if(current.val != stack.pop()) return false;
            current = current.next;
        }
        return true;
    }

    // ====================== BETTTER APPROACH - O(n) | O(1) ======================
    public static boolean isPalindrome(Node head){
        if (head == null || head.next == null) return true;

        // Find the end of the first half and reverse the second half
        Node firstHalfEnd = endOfFirstHalf(head);
        Node secondHalfStart = reverseList(firstHalfEnd.next);

        // checking weather or not ther is a palindrome
        Node p1 = head;
        Node p2 = secondHalfStart;
        boolean result = true;

        while (result && p2 != null) {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    public static Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static Node endOfFirstHalf(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(2);
        head2.next.next.next.next = new Node(4);

        System.out.println("Palindromic List - list-01 : " + isPalindrome(head));
        System.out.println("Palindromic List - list-02 : " + isPalindrome(head2));
    }
}
