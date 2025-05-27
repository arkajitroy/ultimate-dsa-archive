class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: using recursion and divide and conquer
// complexity: O(n log k) | O(log k)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return computeMerger(lists, 0, lists.length - 1);
    }

    private ListNode computeMerger(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode leftList = computeMerger(lists, left, mid);
        ListNode rightList = computeMerger(lists, mid + 1, right);

        return mergeTwoLists(leftList, rightList);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        else current.next = list2;

        return dummy.next;
    }
}