import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Optimal Approach: using fast and slow pointer
// Complexity: O(n) | O(1)
class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // moving the fast pointer ahead by n+1 steps
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        // Move both untill fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow is at (n+1)th from end, remove nth
        slow.next = slow.next.next;

        return dummy.next;
    }
}

// Better Approach: Single pass - using extra space
// Complexity: O(n) | O(n)
class Solution2{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;

        // Adding nodes in the list
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }

        int size = nodes.size();
        if(size == n) return head.next; // remove first node

        ListNode prevNode = nodes.get(size - n - 1);
        prevNode.next = prevNode.next.next;

        return head;
    }
}

// Approach: Brute Force - counter with 2 pass
// Complexity: O(2n) | O(1)
class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        // 1: Computing the length of the linked list
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // 2: removing the nth node by length - n
        if( size == n ) return head.next;

        temp = head;
        for(int i=1; i<size-n; i++){
            temp = temp.next;
        }
        // assigning the pointer to next node
        temp.next = temp.next.next;

        return head;
    }
}