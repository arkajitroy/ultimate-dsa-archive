// Question :
// Given an array of integers arr[], the task is to find the first equilibrium point in the array.
// The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before 
// that index is the same as the sum of elements after it. Return -1 if no such point exists. 

class Solution {
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int totalSum = 0;

        // calcuate total sum of the array elements
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        
        // iterate and check if left sum == right sum
        for (int i = 0; i < n; i++) {
            totalSum -= arr[i]; // totalSum is now the right sum (after i)

            if (leftSum == totalSum) return i;
            leftSum += arr[i];
        }
        return -1;
    }
}
