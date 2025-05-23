import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Approach: Recusive DFS
// complexity: O(n) | O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        // Recurs to the left and right subtrees
        TreeNode leftTrack = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTrack = lowestCommonAncestor(root.right, p, q);

        if(leftTrack != null && rightTrack != null) return root;

        // if both left and right are null, return null or else return the node (not null)
        return leftTrack != null ? leftTrack : rightTrack;
    }
}


// Approach: Brute Force - path comparison
// complexity: O(n) | O(n)

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int index = 0;
        while(index < path1.size() && index < path2.size()){
            if(path1.get(index) != path2.get(index)) break;
            index++;
        }

        return path1.get(index - 1);
    }

    private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null) return false;

        path.add(root);

        if (root == target) return true;

        if (getPath(root.left, target, path) || getPath(root.right, target, path)){
            return true;
        }
        path.remove(path.size() - 1);
        
        return false;
    }
}