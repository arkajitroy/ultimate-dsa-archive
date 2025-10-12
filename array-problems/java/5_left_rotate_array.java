// https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card


// Function to rotate an array by d elements in counter-clockwise direction.


// Approach : Brute Approach
// Complexity: O(n^2) | O(1)

class Solution {
    static void rotateArr(int arr[], int d) {
        int temp = arr[0], n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[n - 1] = temp;
        d--;
        if (d > 0) rotateArr(arr, d);
    }
}

// Approach : Efficient Approach
// Complexity: O(n) | O(1)

class Solution2 {
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n; // In case d > n
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}