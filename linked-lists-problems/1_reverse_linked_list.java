import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: Slow and Fast Pointers
// Complexity : O(n) | O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = null;
        ListNode fast = head;

        while(fast != null){
            ListNode next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        return slow;
    }
}

// Approach: Recursive
// Complexity: O(n) | O(n)

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

// Approach: using stack
// Complexity: O(n) | O(n)

class Solution3 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();
        
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode reversed = stack.pop();
        ListNode current = reversed;

        while(!stack.isEmpty()){
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;
        return reversed;
    }
}