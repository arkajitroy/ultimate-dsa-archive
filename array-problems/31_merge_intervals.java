// Approach: Brute Force
// complexity: O(n) | O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        
        // sort by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        // initially add list
        int[] current = intervals[0];
        merged.add(current);

        // itterate
        for(int[] interval : intervals){
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) current[1] = Math.max(currentEnd, nextEnd);
            else {
                current = interval;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}