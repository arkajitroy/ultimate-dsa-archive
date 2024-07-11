package LinkedLists;

class Main{
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static Node oddEvenList(Node head) {
        if (head == null) return null;

        Node oddHead = new Node(0);  // Dummy head for odd list
        Node evenHead = new Node(0);  // Dummy head for even list
        Node odd = oddHead, even = evenHead;
        Node current = head;
        int index = 1;
        
        while (current != null) {
            if (index % 2 != 0) {
                odd.next = current;
                odd = odd.next;
            } else {
                even.next = current;
                even = even.next;
            }
            current = current.next;
            index++;
        }
        
        even.next = null;  // End the even list
        odd.next = evenHead.next;  // Concatenate even list at the end of odd list
        return oddHead.next;
    }

    public static void printist(Node result){
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(4);
        list1.next.next.next = new Node(2);
        list1.next.next.next.next = new Node(5);
        list1.next.next.next.next.next = new Node(6);

        System.out.println("Base Linked List");
        printist(list1);
        System.out.println("\nOdd-Even Linked Lists");
        oddEvenList(list1);
        printist(list1);
    }
}
