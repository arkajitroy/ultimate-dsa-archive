import java.util.HashMap;

// Approach: HashMap
// complexity: O(n) + O(n) = O(2n) | O(n)

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        // creating a hashmap - map <element, count>
        HashMap<Integer, Integer> map = new HashMap<>();

        // itterate the array, and count the elements
        for(int num : nums){
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        // searching for the majority element - count > n/2
        for(int key : map.keySet()){
            if(map.get(key) > (n/2)) return key;
        }
        return -1;
    }
}


// Approach: Moore Voting Algirthm
// complexity: O(n) | O(1)

class Solution2 {
    public int majorityElement(int[] nums) {
        int count = 0, element = 0, n = nums.length;

        // applying the moore voting algo
        for(int i=0; i<n; i++){
            // checking the count is 0
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(nums[i] == element) count++;
            else count--;
        }

        // checking if the sorted element is majority element
        int majority = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == element) majority++;
        }

        if(majority > (n/2)) return element;

        return -1;
    }
}