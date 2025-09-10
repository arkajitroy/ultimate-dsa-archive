import java.util.Arrays;


// Optimal Approach: using the binary search
// Complexity: O(n log n) | O(1)

class Solution {
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;

        // initializing the limits
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int result = -1;

        // itterating the books using the binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(check(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean check(int[] arr, int k, int pageLimit){
        int count = 1;
        int pageSum = 0;

        for(int idx=0; idx<arr.length; idx++){
            // if adding current book exceeds the page, limit assign book to next student
            if(pageSum + arr[idx] > pageLimit){
                count++;
                pageSum = arr[idx];
            } else{
                pageSum += arr[idx];
            }
        }
        // if books can assigned to less than k student then, it can be assigned to exactly k student as well
        return count <= k;
    }
}

// Brute Force: Itterating over all possibilities
// Complexity: O(n^2) | O(1)

class Solution2 {
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;

        // minimum and maximum page possibility
        int minPageLimit = Arrays.stream(arr).max().getAsInt();
        int maxPageLimit = Arrays.stream(arr).sum();

        // itterating over all possible page limits
        for(int pageLimit=minPageLimit; pageLimit<=maxPageLimit; pageLimit++){
            if(check(arr, k, pageLimit)) return pageLimit; 
        }
        return -1;
    }

    private boolean check(int[] arr, int k, int pageLimit){
        // starting from the first student
        int count = 1;
        int pageSum = 0;

        for(int idx=0; idx<arr.length; idx++){
            // if adding current book exceeds the page, limit assign book to next student
            if(pageSum + arr[idx] > pageLimit){
                count++;
                pageSum = arr[idx];
            } else{
                pageSum += arr[idx];
            }
        }

        // if books can assigned to less than k student then, it can be assigned to exactly k student as well
        return count <= k;
    }
}