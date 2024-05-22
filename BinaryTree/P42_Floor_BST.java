package BinaryTree;

class Main{
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

    public static int floor(TreeNode root, int key){
        int floorValue = Integer.MIN_VALUE;

        while(root != null){
            if(root.val == key) return root.val;
            else if(root.val > key) root = root.left;
            else{
                floorValue = root.val;
                root = root.right;
            }
        }
        return floorValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 11;
        System.out.println("Floor of "+key+" is :" + floor(root, key));
    }
}