class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // Finding the length and last node
        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connecting the lastnode with the head - making it circular
        current.next = head;

        k = k % length;
        int steps = length - k;

        ListNode newTail = current;

        while (steps > 0) {
            newTail = newTail.next;
            steps--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

// Brute Force Approach

class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = getLength(head);
        k = k % length;  // unnecessary full rotations

        for (int i = 0; i < k; i++) {
            head = rotateOnce(head);
        }

        return head;
    }

    private ListNode rotateOnce(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        // 'curr' is last node, 'prev' is second last
        curr.next = head;
        prev.next = null;
        return curr;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
