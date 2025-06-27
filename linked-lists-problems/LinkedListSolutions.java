// Linked List Solutions for LeetCode and GeeksforGeeks Problems
// All solutions are implemented in Java with proper function definitions

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Definition for node with random pointer
class Node {
    int val;
    Node next;
    Node random;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next, Node random) { this.val = val; this.next = next; this.random = random; }
}

// Definition for doubly-linked list
class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    DoublyLinkedListNode child; // For multilevel doubly linked list
    DoublyLinkedListNode(int val) { this.val = val; }
}

// Definition for multilevel linked list node (for GFG Flattening a Linked List)
class MultiLevelNode {
    int val;
    MultiLevelNode next;
    MultiLevelNode bottom;
    MultiLevelNode(int val) { this.val = val; }
}

class LinkedListSolutions {

    // ============================== Easy Level Problems ==============================

    // 1. Reverse a Linked List (LeetCode #206)
     ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 2. Middle of the Linked List (LeetCode #876)
     ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 3. Remove Duplicates from Sorted List (LeetCode #83)
     ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    // 4. Delete Node in a Linked List (LeetCode #237)
     void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 5. Linked List Cycle (LeetCode #141)
     boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 6. Merge Two Sorted Lists (LeetCode #21)
     ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    // 7. Remove Linked List Elements (LeetCode #203)
     ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    // 8. Palindrome Linked List (LeetCode #234)
     boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode secondHalf = reverseList(slow.next);
        // Compare
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // 9. Delete Alternate Nodes of a Linked List (GeeksforGeeks)
     void deleteAlternate(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr.next = curr.next.next;
            curr = curr.next;
        }
    }

    // 10. Count Occurrences in a Linked List (GeeksforGeeks)
     int countOccurrences(ListNode head, int key) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == key) count++;
            curr = curr.next;
        }
        return count;
    }

    // ============================== Medium Level Problems ==============================

    // 11. Remove Nth Node From End of List (LeetCode #19)
     ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // 12. Swap Nodes in Pairs (LeetCode #24)
     ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode rest = swapPairs(next.next);
        head.next = rest;
        next.next = head;
        return next;
    }

    // 13. Odd Even Linked List (LeetCode #328)
     ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // 14. Partition List (LeetCode #86)
     ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0), after = new ListNode(0);
        ListNode beforeCurr = before, afterCurr = after;
        while (head != null) {
            if (head.val < x) {
                beforeCurr.next = head;
                beforeCurr = beforeCurr.next;
            } else {
                afterCurr.next = head;
                afterCurr = afterCurr.next;
            }
            head = head.next;
        }
        afterCurr.next = null;
        beforeCurr.next = after.next;
        return before.next;
    }

    // 15. Intersection of Two Linked Lists (LeetCode #160)
     ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    // 16. Rotate List (LeetCode #61)
     ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // Find length and last node
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        // Make circular
        curr.next = head;
        // Find new tail
        k = k % length;
        for (int i = 0; i < length - k - 1; i++) {
            head = head.next;
        }
        // Break the circle
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    // 17. Add Two Numbers (LeetCode #2)
     ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 18. Detect and Remove Loop in a Linked List (GeeksforGeeks)
     void detectAndRemoveLoop(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return;
        // Find loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // Move fast to last node of loop
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
    }

    // 19. Reverse a Doubly Linked List (GeeksforGeeks)
     DoublyLinkedListNode reverseDoublyList(DoublyLinkedListNode head) {
        if (head == null || head.next == null) return head;
        DoublyLinkedListNode curr = head, temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }

    // 20. Segregate Even and Odd Nodes in a Linked List (GeeksforGeeks)
     ListNode segregateEvenOdd(ListNode head) {
        ListNode evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        if (evenStart == null || oddStart == null) return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    // ============================== Hard Level Problems ==============================

    // 21. Merge k Sorted Lists (LeetCode #23)
     ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        java.util.PriorityQueue<ListNode> pq = new java.util.PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }

    // 22. Copy List with Random Pointer (LeetCode #138)
     Node copyRandomList(Node head) {
        if (head == null) return null;
        // Step 1: Interweave original and copied nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Step 3: Separate original and copied lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            curr.next = copyCurr.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // 23. Reverse Nodes in k-Group (LeetCode #25)
     ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) return head;
        ListNode nextHead = reverseKGroup(curr, k);
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = nextHead;
        return prev;
    }

    // 24. LRU Cache (LeetCode #146)
    class LRUCache {
        class DNode {
            int key, value;
            DNode prev, next;
            DNode(int key, int value) { this.key = key; this.value = value; }
        }
        private java.util.HashMap<Integer, DNode> map;
        private DNode head, tail;
        private int capacity;

         LRUCache(int capacity) {
            this.capacity = capacity;
            map = new java.util.HashMap<>();
            head = new DNode(0, 0);
            tail = new DNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

         int get(int key) {
            DNode node = map.get(key);
            if (node == null) return -1;
            moveToFront(node);
            return node.value;
        }

         void put(int key, int value) {
            DNode node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToFront(node);
            } else {
                node = new DNode(key, value);
                map.put(key, node);
                addToFront(node);
                if (map.size() > capacity) {
                    DNode lru = tail.prev;
                    map.remove(lru.key);
                    removeNode(lru);
                }
            }
        }

        private void addToFront(DNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToFront(DNode node) {
            removeNode(node);
            addToFront(node);
        }
    }

    // 25. Flatten a Multilevel Doubly Linked List (LeetCode #430)
     DoublyLinkedListNode flatten(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                DoublyLinkedListNode next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;
                while (curr.next != null) curr = curr.next;
                curr.next = next;
                if (next != null) next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    // 26. Clone a Linked List with Next and Random Pointer (GeeksforGeeks)
    // Same as LeetCode #138, reusing copyRandomList
     Node cloneListWithRandom(Node head) {
        return copyRandomList(head);
    }

    // 27. Reverse a Linked List in Groups of Given Size (GeeksforGeeks)
     ListNode reverseInGroups(ListNode head, int k) {
        return reverseKGroup(head, k); // Same as LeetCode #25
    }

    // 28. Flattening a Linked List (GeeksforGeeks)
     MultiLevelNode flattenMultiLevelList(MultiLevelNode head) {
        if (head == null) return null;
        MultiLevelNode curr = head;
        while (curr != null) {
            if (curr.bottom != null) {
                MultiLevelNode bottom = flattenMultiLevelList(curr.bottom);
                curr.bottom = null;
                MultiLevelNode temp = curr.next;
                curr.next = bottom;
                MultiLevelNode tail = bottom;
                while (tail.next != null) tail = tail.next;
                tail.next = temp;
            }
            curr = curr.next;
        }
        return head;
    }

    // 29. Delete Nodes Which Have a Greater Value on Right Side (GeeksforGeeks)
     ListNode deleteNodesGreaterOnRight(ListNode head) {
        if (head == null || head.next == null) return head;
        // Reverse the list
        head = reverseList(head);
        // Delete nodes
        ListNode curr = head;
        int max = curr.val;
        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
        // Reverse back
        return reverseList(head);
    }

    // 30. Add 1 to a Number Represented as Linked List (GeeksforGeeks)
     ListNode addOne(ListNode head) {
        // Reverse the list
        head = reverseList(head);
        ListNode curr = head;
        int carry = 1;
        ListNode prev = null;
        while (curr != null && carry != 0) {
            int sum = curr.val + carry;
            carry = sum / 10;
            curr.val = sum % 10;
            prev = curr;
            curr = curr.next;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        // Reverse back
        return reverseList(head);
    }
}