class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// ! Inplace Reversal (optimal)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode groupNext = kth.next;

            // Temporarily disconnect the group
            kth.next = null;

            // Reverse the group
            ListNode newGroupHead = reverse(groupStart);
            
            prevGroupEnd.next = newGroupHead; // Connect previous group end to new group head
            groupStart.next = groupNext; // Connect group start (which is now end) to the next group
            prevGroupEnd = groupStart; // Move prevGroupEnd to the end of the reversed group
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}



// ! Recursive reverse k-group with helper functions
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are at least k nodes ahead
        ListNode temp = head;
        int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count < k) return head; // Not enough nodes to reverse

        // Step 2: Reverse first k nodes
        ListNode newHead = reverse(head, k);

        // Step 3: Recurse on the remaining list starting from temp
        head.next = reverseKGroup(temp, k);  // 'head' is now the tail after reversal

        return newHead;
    }

    // Reverse k nodes and return new head
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, curr = head;

        while (k > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
