package Graphs;

import java.util.ArrayList;

class Main{
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        //performing dfs from the vertext
        for(int index=0; index<V; index++){
            if(dfsCheck(index, visited, pathVisited, adj)) return true;
        }
        return false;
    }

    private static boolean dfsCheck(int vertex, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj){
        if(pathVisited[vertex]) return true;
        if(visited[vertex]) return false;

        // marging the current node as visited and add it to path-visited
        visited[vertex] = true;
        pathVisited[vertex] = true;

        // checking for every adjacent node of the vertex
        for(int neighbor : adj.get(vertex)){
            if(dfsCheck(neighbor, visited, pathVisited, adj)) return true;
        }

        // removing the vertex from path-visited
        pathVisited[vertex] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);
        
        boolean hasCycle = isCyclic(V, adj);
        
        if (hasCycle) System.out.println("Graph contains cycle");
        else System.out.println("Graph doesn't contain cycle");
    }
} 