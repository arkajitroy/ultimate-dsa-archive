package LinkedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Main {
    private static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;

        // Finding the middle of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode prev = null, curr = slow.next;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Compare both halves
        ListNode firstHalf = head, secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        
        // Check if the linked list is a palindrome
        boolean result = isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);
    }
}
