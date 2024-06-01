package ArrayProblems;

import java.util.PriorityQueue;

class Main{

    // Find the Kth Largest Element - using PriorityQueue - minHeap
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    // Find the Kth Smallest Element - using Priority Queue - maxHeap
    public static int findKthSmallest(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int num : nums){
            maxHeap.offer(num);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int kth_largest = 4;
        int kth_smallest = 3;
        System.out.println(kth_smallest +" th smallest : " + findKthSmallest(nums, kth_smallest));
        System.out.println(kth_largest +" th largest : " + findKthLargest(nums, kth_largest));
    }
}