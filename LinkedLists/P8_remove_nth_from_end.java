package LinkedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // moving fast pointer to the nth node
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        // Moving both slow and fast pointers
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Remove the 2nd node from the end

        ListNode result = removeNthFromEnd(head, n);

        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }    
}