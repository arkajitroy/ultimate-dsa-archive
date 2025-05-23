class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: Two Pass
// Complexity: O(2N) | O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int length = 0;
        ListNode temp = head;

        // Calculating the length of list
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If the head is the node to remove
        if (length == n) return head.next;

        // Second pass: find the node just before the one to delete
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Skip the node to delete
        if (temp.next != null) temp.next = temp.next.next;

        return head;
    }
}

// Approach: one pass
// Complexity: O(n) | O(1)

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        // move first pointer to n+1 step
        for(int i=0; i<n+1; i++){
            first = first.next;
        }

        // move both pointers
        while(first != null){
            first = first.next;
            second = second.next;
        }

        // remove the nth node from end
        second.next = second.next.next;
        return dummy.next;
    }
}