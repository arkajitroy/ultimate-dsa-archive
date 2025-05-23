class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Easiest approach
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// approach: using iteration

class Solution2{
    public void deleteNode(ListNode node) {
        ListNode current = node;
        while(current.next != null){
            current.val = current.next.val;
            if(current.next.next == null){
                current.next = null;
                break;
            }
            current = current.next;
        }
    }
}
