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

    // Better Approach: O(2n) | O(n)
    public static Node reverseList_better(Node head) {
        if(head == null || head.next == null) return head;

        Stack<Node> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        Node reversed = stack.pop();
        Node current = reversed;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;

        return reversed;
    }

    // Optimal Approach: O(n) | O(1)
    public static Node reverseList(Node head) {
        if(head == null || head.next == null) return head;
        
        Node reversed = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    public static void printLL(Node result){
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Base Linked Lists");
        printLL(head);
        Node result = reverseList(head);
        System.out.println("\nBase Linked Lists");
        printLL(result);
    }
}
