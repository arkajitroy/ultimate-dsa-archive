package LinkedLists;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    // ============================= APPROACH : O(3n) | O(1) ==============================

    public static Node addingOne(Node head){
        if(head == null) return new Node(1);

        // reversing the linked-list
        head = reverseList(head);

        // adding 1 to the linked-list
        Node current = head;
        int carry = 1;
        while (current != null) {
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;

            if (carry == 0) break;

            if (current.next == null && carry > 0) current.next = new Node(0);

            current = current.next;
        }

        head = reverseList(head);

        return head;

    }

    private static Node reverseList(Node head){
        Node reversed = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }

    // ============================= RECURSIVE APPROACH : O(n) | O(n) ==============================

    public static Node addOne_recursive(Node head) {
        if (head == null) return new Node(1);

        int carry = addWithCarry(head);
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private static int addWithCarry(Node node) {
        if (node == null) return 1;

        int carry = addWithCarry(node.next);
        int sum = node.val + carry;
        node.val = sum % 10;
        return sum / 10;
    }
    // ============================= PRINTING ==============================

    private static String printLL(Node head){
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

    // ============================= MAIN ==============================

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(9);

        System.out.println("Before Adding : "+printLL(head));
        addingOne(head);
        System.out.println("After +1 addition : "+printLL(head));
    }
}
