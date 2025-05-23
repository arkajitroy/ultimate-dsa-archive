class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}

class Solution {
    public void deleteAlt(Node head) {
        if(head == null || head.next == null) return;
        Node current = head;
        Node nextNode = head.next;

        while(current != null && nextNode != null){
            current.next = nextNode.next;
            current = current.next;

            if(current != null) nextNode = current.next;
            else break;
        }
    }
}
