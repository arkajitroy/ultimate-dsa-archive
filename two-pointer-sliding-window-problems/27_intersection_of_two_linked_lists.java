import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Optimal Approach: using the two pointer approach
// Complexity: O(n) | O(1)
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : headA.next;
            nodeB = (nodeB == null) ? headA : headB.next;
        }
        return nodeA;
    }
}

// Brute Force Approach: using the nested loop
// Complexity: O(2n) | O(n)
class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        // store all nodes of list-a
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // Now traversing the B and checking it with the set
        while (headB != null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}

// Brute Force Approach: using the nested loop
// Complexity: O(n * n) | O(1)
class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode nodeB = headB;
            // Compare node-b with the node-a and find the intersection point
            while (nodeB != null) {
                if(nodeA == nodeB) return nodeA;
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }
}