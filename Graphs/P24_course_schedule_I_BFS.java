package Graphs;

class Main {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        
        // Using DFS approach
        boolean canFinishBFS = canFinish(numCourses, prerequisites);
        System.out.println("Can we schedule the course - DFS: " + canFinishBFS);
    }
}
