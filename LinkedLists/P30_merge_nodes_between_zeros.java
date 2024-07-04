package LinkedLists;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static Node mergeNodes(Node head){
        Node current = head.next;
        Node dummy = new Node(0);
        Node newListTrail = dummy;
        int sum = 0;

        while (current != null) {
            if(current.val == 0){
                newListTrail.next = new Node(sum);
                newListTrail = newListTrail.next;
                sum = 0;
            }else{
                sum += current.val;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating the input list: 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
        Node head = new Node(0);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(0);

        System.out.println("Base Linked List");
        printLL(head);

        System.out.println("Merged Nodes");
        printLL(mergeNodes(head));
    }
}
