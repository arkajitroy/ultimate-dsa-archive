// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/948595305/

class Solution {
    public int findKthLargest(int[] nums, int k) {
       List<Integer> minHeap = new ArrayList<>();
       int n = nums.length;

       for(int num : nums){
        minHeap.add(num);
       }

       Collection.sort(minHeap);
       return minHeap.get(n-k);
    }
}

// using the priortiy queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}