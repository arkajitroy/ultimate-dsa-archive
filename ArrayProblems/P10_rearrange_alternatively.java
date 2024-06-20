package ArrayProblems;

import java.util.Arrays;

class Main {
    public static void rearrange(long arr[], int n) {
        long[] temp = new long[n];

        // pointers for max and min elements
        int minIndex = 0, maxIndex = n-1;
        boolean flag = true;

        for(int i=0; i<n; i++){
            if(flag) temp[i] = arr[maxIndex--];
            else temp[i] = arr[minIndex++];
            flag = !flag;
        }
        // copying the element frrom temp back to the original array
        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6};
        
        System.out.println("Original Array : " + Arrays.toString(arr));
        rearrange(arr, arr.length);
        System.out.println("Re-arranged Array : " + Arrays.toString(arr));
    }
}
