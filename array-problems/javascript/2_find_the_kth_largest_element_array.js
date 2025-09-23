import { MinHeap } from "./utils/min-heap";

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

// Optimal Approach: using minheap (priority queue) | O(n log k) - Min Heap
function findKthLargestOptimal(nums, k) {
  const minHeap = new MinHeap();
  for (let num of nums) {
    minHeap.insert(num);
    if (minHeap.size() > k) minHeap.extractMin();
  }
  return minHeap.peek();
}

// Better Approach: using sorting | O(n log n) | O(1)
function findKthLargestBetter(nums, k) {
  nums.sort((a, b) => b - a);
  return nums[k - 1];
}
