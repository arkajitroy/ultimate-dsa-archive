package LinkedLists;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void printist(Node result){
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    // ================================================ APPROACH-02 : Using Dummy Nodes - O(n) | O(1)
    public static Node segregate(Node head){
        if(head == null) return head;

        // initiallizing the dummy pointers
        Node dummy0 = new Node(0);
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Traversing the list
        Node zero = dummy0, one = dummy1, two = dummy2;

        Node current = head;
        while(current != null){
            if(current.val == 0) {
                zero.next = current;
                zero = zero.next;
            }
            else if(current.val == 1) {
                one.next = current;
                one = one.next;
            }
            else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }

        // Connecting all three lists
        zero.next = (dummy1.next != null) ? dummy1.next : dummy2.next;
        one.next = dummy2.next;
        two.next = null;

        return dummy0.next;
    }



    // ================================================ APPROACH-01 : Using Counter - O(2n) | O(1)

    public static Node segregate_1(Node head){
        if(head == null) return head;

        int count0 = 0, count1 = 0, count2 = 0;
        Node current = head;

        // counting all the occurance
        while (current != null) {
            if(current.val == 0) count0++;
            else if(current.val == 1) count1++;
            else if(current.val == 2) count2++;
            current = current.next;
        }
        // reassinging the current to head
        current = head;

        // overwrite the nodes
        while (count0 > 0){
            current.val = 0;
            current = current.next;
            count0--;
        }
        while (count1 > 0){
            current.val = 1;
            current = current.next;
            count1--;
        }
        while (count2 > 0){
            current.val = 2;
            current = current.next;
            count2--;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        Node result_1 = segregate_1(head);
        Node result_2 = segregate(head);

        System.out.println("Base Linked List");
        printist(head);

        System.out.println("\nSorted Lists : 0-1-2 - approach-1");
        printist(result_1);
        System.out.println("\nSorted Lists : 0-1-2 - approach-2");
        printist(result_2);
    }
}
