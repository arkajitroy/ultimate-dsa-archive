import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Better Approach : Slow and fast pointer
// Compllexity : O(n) | O(1)
class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // 1: detecting the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 2: cycle detected and find the start point
            if(slow == fast){
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// Better Approach : modifying the links
// Compllexity : O(n) | O(1)
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if(temp.val == Integer.MAX_VALUE) return temp;
            temp.val = Integer.MAX_VALUE; // marking as visited with max-val
            temp = temp.next;
        }
        return null;
    }
}

// Brute Approach : using Hashset
// Compllexity : O(n) | O(n)
class Solution3 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if(visited.contains(temp)) return temp;
            visited.add(temp);
            temp = temp.next;
        }
        return null;
    }
}