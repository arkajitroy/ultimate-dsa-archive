import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach : using slow and fast pointers - Floyd's cycle detection algorithm
// Compllexity : O(n) | O(1)
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }
}

// Approach : using hashset
// Compllexity : O(n) | O(n)

class Solution2 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = head;

        while(current != null){
            if(set.contains(current)) return true;
            set.add(current);
            current = current.next;
        }

        return false;
    }
}