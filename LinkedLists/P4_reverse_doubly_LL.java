package LinkedLists;

class Main {
    static class Node {
        int data;
        Node next, prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node reverseDLL(Node head){
        if(head == null) return null;

        Node current = head;
        Node temp = null;

        while (current != null) {
            // swap next and prev pointers
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            //move to next node
            current = current.prev;
        }
        // assigning the head-pointer to the next node
        if(temp != null) head = temp.prev;
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Base Linked List");
        printLL(head);

        System.out.println("\nBase Linked List");
        head = reverseDLL(head);
        printLL(head);
    }
    
}
