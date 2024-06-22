package ArrayProblems;
import java.util.*;

class Main {
    public static int getCountPairs(int[] nums, int n, int sum){
        // freq-map - < digit , count >
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            int complement = sum - nums[i];
            // check if the complement present or not
            if(map.containsKey(complement)) count += map.get(complement);
            // add the current element to the map
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return count;
    }

    public static List<int[]> getPairs(int[] nums, int n, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> pairList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int complement = sum - nums[i];
            // Check if the complement is present in the map
            if (map.containsKey(complement)) {
                int count = map.get(complement);
                for (int j = 0; j < count; j++) {
                    pairList.add(new int[]{complement, nums[i]});
                }
            }
            // Add the current element to the map
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return pairList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.println("Count of pairs with given sum : " + getCountPairs(arr, arr.length, sum));
        System.out.println("Pairs of : ");
        List<int[]> result = getPairs(arr, arr.length, sum);
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}
