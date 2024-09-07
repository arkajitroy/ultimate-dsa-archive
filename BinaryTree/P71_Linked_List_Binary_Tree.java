package BinaryTree;

class P71_Linked_List_Binary_Tree {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSubPath(ListNode list, TreeNode root){
        if(root == null) return false;
        return dfsCheck(list, root) || isSubPath(list, root.left) || isSubPath(list, root.right);
    }

    private static boolean dfsCheck(ListNode list, TreeNode root){
        if(list == null) return true;
        if(root == null) return false;

        if(root.val == list.val){
            return dfsCheck(list.next, root.left) || dfsCheck(list.next, root.right);
        }

        return false;
    }

    public static void main(String[] args) {
        // Sample list
        ListNode list = new ListNode(4);
        list.next = new ListNode(2);
        list.next.next = new ListNode(8);

        // Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        boolean result = isSubPath(list, root);
        System.out.println("Is Linked List is a Sub Path : "+ result);
    }    
}
