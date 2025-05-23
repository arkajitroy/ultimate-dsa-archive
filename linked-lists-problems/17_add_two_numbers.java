class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode dummy = new ListNode(-1); // Dummy node to start the result list
        ListNode current = dummy;

        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;

            // if t1 is not null then add it to sum and move the pointer to next node
            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next; // Move to the next node in list1
            }

            // Similarly like t1 pointer do the operation
            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }
            
            // 
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // If any thing is left in the carry then add to current.next
        if (carry > 0) current.next = new ListNode(carry);

        return dummy.next; 
    }
}