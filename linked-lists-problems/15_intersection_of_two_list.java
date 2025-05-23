import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: using the two pointer
// Complexity: O(n) | O(1)
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }
}

// Approch: using the hashtable
// Complexity: O(2n) | O(n)

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode currNode = headA;

        // Storing all the nodes in the hashset
        while (currNode != null) {
            set.add(currNode);
            currNode = currNode.next;
        }

        // initializing the head-b to the current and then traverse
        currNode = headB;

        // if it finds the similar element in the set, it will return the value
        while (currNode != null) {
            if(set.contains(currNode)) return currNode;
            currNode = currNode.next;
        }

        return null;
    }
}