package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

class Main {
    // Brute Solution : O(N^2)
    public static int majorityElement_brute(int[] nums){
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] == nums[i]) count++;
            }
            // check if the frequency is greater than n/2
            if(count > (nums.length/2)) return nums[i];
        }
        return -1;
    }

    // Better Solution : O(n * log n) + O(n)
    public static int majorityElement_better(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>(); // map<num, count>
        // storing all the elements in the map
        for(int element=0; element<nums.length; element++){
            int value = map.getOrDefault(nums[element], 0);
            map.put(nums[element], value + 1);
        }

        // searching for the majority element
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() > (nums.length / 2)) return it.getKey();
        }
        return -1;
    }

    // Optimal Solution - Moore Voting Algorithm : O(n) + O(n)
     public static int majorityElement_OP(int[] nums){
        int count = 0, element = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0) {
                count = 1;
                element = nums[i];
            }
            else if(nums[i] == element) count++;
            else count--;
        }
        // checking if the sorted element is majority elemnet
        int majorityCount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element) majorityCount++;
        }

        if(majorityCount > (nums.length / 2)) return element;
        return -1;
     }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 1, 2, 2 };

        System.out.println("Majority Element - Brute " +majorityElement_brute(nums));
        System.out.println("Majority Element - Better " +majorityElement_better(nums));
        System.out.println("Majority Element - Optimal " +majorityElement_OP(nums));
    }
}