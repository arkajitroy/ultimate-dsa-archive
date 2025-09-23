/**
 * @param {number[]} nums
 * @return {number}
 */

// Optimal Approach: using linear scan | O(n) | O(1)
const findKthLargestOptimal = (nums) => {
  let max = nums[0];
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] > max) max = nums[i];
  }
  return max;
};

// Better Approach: using sorting | O(n log n) | O(1)
const findKthLargestBetter = (nums) => {
  nums.sort((a, b) => b - a);
  return nums[0];
};
