import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: Slow and fast pointers
// Complexity : O(n) | O(1)

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// Approach: using stack

class Solution2 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Step 1: Push all nodes into the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Step 2: Calculate middle index
        int size = stack.size();
        int middleIndex = size / 2;

        // Step 3: Traverse from head to middleIndex
        current = head;
        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        return current;
    }
}