import java.util.Arrays;

class Solution {
    public int findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return arr[mid];
            else if (arr[mid] < target) {
                floor = arr[mid]; // candidate floor
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return floor;
    }

    public int findCeil(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return arr[mid];
            else if (arr[mid] < target) low = mid + 1;
            else{
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4, 6, 10, 12};

        int target = 5;
        System.out.println("Array: " + Arrays.toString(arr) + " : key : "+target);
        System.out.println("Floor of = " + sol.findFloor(arr, target));
        System.out.println("Ceil of = " + sol.findCeil(arr, target));
    }
}