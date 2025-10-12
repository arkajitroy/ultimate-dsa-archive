// Approach: Counting Sort
// Complexity: O(n) | O(1)

class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for(int num : nums){
            counts[num]++;
        }

        int index = 0;
        
        for(int color = 0; color <=2; color++){
            while(counts[color] > 0){
                nums[index++] = color;
                counts[color]--;
            }
        }
    }
}

// Approach: Two Pointers
// Complexity: O(n) | O(1)

class Solution2 {
    public void sortColors(int[] nums) {
        int lo=0, mid=0, hi=nums.length-1;

        while(mid <= hi){
            if(nums[mid] == 0){
                swap(nums, lo, mid);
                lo++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, hi);
                hi--;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}