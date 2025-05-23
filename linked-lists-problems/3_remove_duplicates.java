
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Note: The linked list is sorted in ascending order.

// Approach: using slow and fast pointers
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            if (prev != null && prev.val == current.val) prev.next = next;
            else prev = current;
            current = next;
        }
        return head;
    }
}

// Approach : using recursion

class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        if(head.val == head.next.val) {
            head.next = head.next.next; // changing the next pointer
            return deleteDuplicates(head);
        }
        else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}