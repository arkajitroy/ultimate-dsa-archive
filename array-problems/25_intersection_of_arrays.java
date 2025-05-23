import java.util.*;

// Approach: Hashset - brute force
// complexity: O(n^2) | O(k)

class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        for(int num1 : nums1){
            for(int num2 : nums2){
                if(num1 == num2){
                    result.add(num1);
                    break;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// Approach: Hashset - optimized
// complexity: O(n + m) | O(n + k)

class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> track = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) track.add(num);

        for (int num : nums2) {
            if (track.contains(num)) result.add(num); // uniqueness maintained
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}

// Approach: Sorting + Two pointers
// complexity: O(n log n + m log m) | O(k)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> result = new HashSet<>();
        int i=0, j=0;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return result.stream().mapToInt(num -> num).toArray();
    }
}