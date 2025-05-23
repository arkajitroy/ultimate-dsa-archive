// https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

class Solution {
    public static int largest(int[] arr) {
        int max = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) max = arr[i]
        }
        return max;
    }
}