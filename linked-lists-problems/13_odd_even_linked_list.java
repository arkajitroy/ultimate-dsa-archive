class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: using pointers

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        // itterating the list with the even
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next; // increasing the odd head
            even.next = odd.next;
            even = even.next; // increasing the odd head
        }

        odd.next = evenHead;
        return head;
    }
}