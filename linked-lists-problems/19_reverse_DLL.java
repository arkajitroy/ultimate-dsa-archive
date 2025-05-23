import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

// Approach: Two pointers
// Complexity: O(n) | O(1)

class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        if(head == null) return null;

        DLLNode current = head;
        DLLNode prev = null;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;

            // move to the next node
            current = current.prev;
        }

        return prev == null ? head : prev.prev;
    }
}

// Approach: using a list to store value
// Complexity: O(n) | O(n)

class Solution2 {
    public DLLNode reverseDLL(DLLNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Store all node values in a list
        List<Integer> values = new ArrayList<>();
        DLLNode temp = head;
        while (temp != null) {
            values.add(temp.data);
            temp = temp.next;
        }

        // Step 2: Traverse again and overwrite values in reverse order
        temp = head;
        for (int i = values.size() - 1; i >= 0; i--) {
            temp.data = values.get(i);
            temp = temp.next;
        }

        return head;
    }
}