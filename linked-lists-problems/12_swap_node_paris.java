class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // now we will iterate the list
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // perform swapping
            swap(first, second, current);

            // moving the current pointers forward
            current = first;
        }
        return dummy.next;
    }

    private void swap(ListNode first, ListNode second, ListNode current){
        first.next = second.next;
        second.next = first;
        current.next = second;
    }
}