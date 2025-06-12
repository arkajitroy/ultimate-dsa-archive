import java.util.*;

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

class Pair {
    TreeNode node;
    int vertical;
    Pair(TreeNode n, int col){
        this.node = n;
        this.vertical = col;
    }
}

// BFS: Teemap + Queue (Recommended solution)
// complexity: O(n) | O(n)

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store column -> list of values
        TreeMap<Integer, List<Integer>> columnTable = new TreeMap<>();

        // Queue to perform BFS, stores pair of node and its column index
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int column = pair.vertical;

            columnTable.putIfAbsent(column, new ArrayList<>());
            columnTable.get(column).add(node.val);

            // traversing the subnodes
            if(node.left != null) queue.offer(new Pair(node.left, column-1));
            if(node.right != null) queue.offer(new Pair(node.right, column+1));
        }

        // collect result in order of column
        for(List<Integer> col : columnTable.values()){
            result.add(col);
        }

        return result;
    }
}

// DFS : TreeMap + HashMap of PriorityQueue
// complexity: O(n) | O(n)

class Solution2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> columnMap = new TreeMap<>();
    
        dfs(root, 0, 0, columnMap);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Process each column in sorted order of x (from TreeMap)
        for (List<int[]> nodes : columnMap.values()) {
            Collections.sort(nodes, (a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            
            // Extract values and add to the result list
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] node : nodes) {
                sortedColumn.add(node[1]);
            }
            result.add(sortedColumn);
        }
        
        return result;
    }

    private void dfs(TreeNode node, int x, int y, TreeMap<Integer, List<int[]>> columnMap) {
        if (node == null) return;

        columnMap.putIfAbsent(x, new ArrayList<>());
        columnMap.get(x).add(new int[]{y, node.val});
        
        dfs(node.left, x - 1, y + 1, columnMap); // Move to the left child
        dfs(node.right, x + 1, y + 1, columnMap); // Move to the right child
    }
}