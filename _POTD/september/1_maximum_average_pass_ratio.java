// ! Need to practice the problem again

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap based on gain
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );
        // Push all classes into heap
        for(int[] cls : classes){
            maxHeap.add(cls);
        }

        // Allocating extra student one by one
        while (extraStudents > 0) {
            extraStudents--;
            int[] top = maxHeap.poll(); // class with highest gain
            top[0] += 1; // +increase pass
            top[1] += 1; // +increase total
            maxHeap.offer(top);
        }

        // Compute final average
        double sum = 0.0;
        for(int[] cls : maxHeap){
            sum += (double) cls[0]/cls[1];
        }
        
        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        double curr = (double) pass / total;
        double next = (double) (pass + 1) / (total + 1);
        return next - curr;
    }
}