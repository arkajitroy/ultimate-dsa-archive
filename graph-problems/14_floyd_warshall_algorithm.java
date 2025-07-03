// From every node we have to tell the shortest path to every node
// Also know as multisource shortest path algorithm
// Helps to find the negative cycle

class Solution {
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        int INF = (int) 1e8; // 10^8 as infinity

        // Floyd-Warshall Algorithm
        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from i to j
                    if (dist[i][via] < INF && dist[via][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int col : row){
                System.out.print((col == 1e8 ? "INF" : col) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // INF - Infinity : if there is no edge then we will represent as infinite
        int INF = (int) 1e8;

        int[][] dist = {
            {0, 4, INF, 5, INF},
            {INF, 0, 1, INF, 6},
            {2, INF, 0, 3, INF},
            {INF, INF, 1, 0, 2},
            {1, INF, INF, 4, 0}
        };

        int[][] dist2 = {
            {0, 2, INF, INF},
            {1, 0, 3, INF},
            {INF, INF, 0, INF},
            {3, 5, 4, 0},
        };

        Solution sol = new Solution();
        sol.floydWarshall(dist);
        sol.floydWarshall(dist2);

        System.out.println("Shortest distance matrix:");
        printMatrix(dist2);
    }
}