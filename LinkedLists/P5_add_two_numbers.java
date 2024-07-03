package LinkedLists;

class Main {
    static class Node {
        int val;
        Node next;

        Node() {};
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static Node addTwoNumbers (Node list1, Node list2){
        Node result = new Node();
        Node temp = result;

        int carry = 0;
        while (list1 != null || list2 != null || carry != 0) {
            int sum = 0;
            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }
            // now after taking both the nodes value
            sum += carry;
            carry = sum / 10;

            Node remainder = new Node(sum % 10);
            temp.next = remainder;
            temp = temp.next;
        }
        return result.next;
    }

    public static void printLL(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node list1 = new Node(2);
        list1.next = new Node(4);
        list1.next.next = new Node(3);

        Node list2 = new Node(5);
        list2.next = new Node(6);
        list2.next.next = new Node(4);

        System.out.println("# Base Lists");
        printLL(list1);
        printLL(list2);

        System.out.println("\n# Summation Result");
        Node result = addTwoNumbers(list1, list2);
        printLL(result);
    }
}
