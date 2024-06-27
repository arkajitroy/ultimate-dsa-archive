package ArrayProblems;

class Main {
    public static int findMaxConsecutiveOnes(int[] nums){
        int count = 0, maximum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) count++;
            else count = 0;
            maximum = Math.max(maximum, count);
        }
        return maximum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }
}
